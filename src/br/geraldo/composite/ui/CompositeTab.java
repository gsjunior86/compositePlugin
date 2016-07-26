package br.geraldo.composite.ui;



import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import br.geraldo.composite.CompositePlugin;
import br.geraldo.composite.ui.table.Configuration;
import br.geraldo.composite.ui.table.ModelSource;

public class CompositeTab extends AbstractLaunchConfigurationTab {

	private TableViewer tableViewer;
	private static final String COLUMN_NAME = "Name";
	private static final String COLUMN_TYPE = "Type";
	private final ILaunchManager manager;
	
	
	public CompositeTab() {
		manager = getLaunchManager();
	}
	
	@Override
	public boolean canSave() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void createControl(Composite parent) {
		
		
		tableViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
		        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER | SWT.CHECK);
		
		createTableViewer();
	    setControl(tableViewer.getTable());
	    
//	    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(comp);
//	    
//	    Label label = new Label(comp, SWT.NONE);
//	    label.setText("Console Text:");
//	    GridDataFactory.swtDefaults().applyTo(label);
//
//	    text = new Text(comp, SWT.BORDER);
//	    text.setMessage("");
//	    GridDataFactory.fillDefaults().grab(true, false).applyTo(text);
//	    
//	    selected = new LinkedHashSet<Configuration>();
//	    
//	    createTableViewer(comp);
	   
	}
	
	/**
	 * Method responsible for initialize the table viewer object
	 * 
	 * @author Geraldo
	 * 
	 */
	
	public void createTableViewer(){

		createColumns(tableViewer);
		
		
		final Table table = tableViewer.getTable();
		table.removeAll();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		table.setVisible(true);
		
		table.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	  if (event.detail == SWT.CHECK) {
			    		  updateLaunchConfigurationDialog();	  
		    	  }
			    }
		});
		
		
		tableViewer.setContentProvider(new ArrayContentProvider());
		try {
			
			List<Configuration> listConfig = ModelSource.getInstance(manager.getLaunchConfigurations()).getConfigList();
			if(listConfig.isEmpty()){
				setErrorMessage(CompositePlugin.NO_CONFIGURATIONS_MESSAGE);
				tableViewer.getTable().setEnabled(false);
			}else{
				tableViewer.setInput(listConfig);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    tableViewer.getControl().setLayoutData(gridData);
	}
	
	
	/**
	 * Method that initializes the table's columns
	 * 
	 * @author Geraldo
	 * 
	 */
	public void createColumns(TableViewer tableViewer){
		String[] titles = {"","",COLUMN_NAME,COLUMN_TYPE};
		int[] bounds = { 30,20, 160, 150};
		
		TableViewerColumn colChecked = createTableViewerColumn(titles[0], bounds[0], 0,false);
		colChecked.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        return "";
		      }
		 });
		
		TableViewerColumn colImage = createTableViewerColumn(titles[1], bounds[1], 1,false);
		colImage.setLabelProvider(new ColumnLabelProvider() {
			
			@Override
			public String getText(Object element) {
				return "";
			}
			
		      @Override
		    public Image getImage(Object element) {
		    	Configuration c = (Configuration) element;
		    	return c.getImage();
		    }
		 });
		
		TableViewerColumn colName = createTableViewerColumn(titles[2], bounds[2], 2,true);
		colName.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        Configuration c = (Configuration) element;
		        return c.getName();
		      }
		 });
		
		TableViewerColumn colType = createTableViewerColumn(titles[3], bounds[3], 3,true);
		colType.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        Configuration c = (Configuration) element;
		        return c.getType();
		      }
		 });
		
		
		
	}
	
	public TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber,boolean resizable){
		final TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		 final TableColumn column = viewerColumn.getColumn();
		 column.setText(title);
		 column.setWidth(bound);
		 column.setResizable(resizable);
		 column.setMoveable(true);
		 return viewerColumn;
		
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		
		
	}
	
	private void prepareSelectedConfigurations(Set<String> checkedMementos){

		List<ILaunchConfiguration> listLaunchConfig = new LinkedList<ILaunchConfiguration>();
		try {
			for(ILaunchConfiguration ilc : manager.getLaunchConfigurations()){
				if(checkedMementos.contains(ilc.getMemento())){
					listLaunchConfig.add(ilc);
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CompositePlugin.setConfigurations(listLaunchConfig);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		
		try {
				Set<String> checkedMementos = configuration.getAttribute("selected", new LinkedHashSet<String>());
				
				for(TableItem item : tableViewer.getTable().getItems()){
					Configuration c = (Configuration) item.getData();
					if(checkedMementos.contains(c.getMemento())){
						item.setChecked(true);
						
					}else{
						item.setChecked(false);
					}
				}
				
				prepareSelectedConfigurations(checkedMementos);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		if(tableViewer.getTable().getItems().length == 0){
			return false;
		}
		return super.isValid(launchConfig);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		
		if(tableViewer.getTable().getItems().length != 0){
			configuration.removeAttribute("selected");
			Set<String> checkedMementos = new LinkedHashSet<String>();
			for(TableItem item: tableViewer.getTable().getItems()){
				if(item.getChecked()){
					Configuration c = (Configuration) item.getData();
					checkedMementos.add(c.getMemento());
				}
			}
			configuration.setAttribute("selected", checkedMementos);
			prepareSelectedConfigurations(checkedMementos);
		}
		
//		if(!selected.isEmpty()){
//			configuration.removeAttribute("selected");
//			Set<String> checkedMementos = new LinkedHashSet<String>();
//			for(Configuration c : selected){
//				checkedMementos.add(c.getMemento());
//			}
//			
//			configuration.setAttribute("selected", checkedMementos);
//		}
		
		
	}
	
	

	@Override
	public String getName() {
		return "Composite launch tab";
	}

}
