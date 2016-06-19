package br.geraldo.composite.ui;



import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import br.geraldo.composite.ui.table.Configuration;
import br.geraldo.composite.ui.table.ModelSource;

public class CompositeTab extends AbstractLaunchConfigurationTab {

	private Text text;
	private TableViewer tableViewer;
	private static final String COLUMN_NAME = "Name";
	private static final String COLUMN_TYPE = "Type";
	private final ILaunchManager manager;
	
	
	public CompositeTab() {
		manager = getLaunchManager();
	}
	
	@Override
	public void createControl(Composite parent) {
		
		Composite comp = new Group(parent, SWT.BORDER);
	    setControl(comp);
	    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(comp);
	    
	    Label label = new Label(comp, SWT.NONE);
	    label.setText("Console Text:");
	    GridDataFactory.swtDefaults().applyTo(label);

	    text = new Text(comp, SWT.BORDER);
	    text.setMessage("Console Text");
	    GridDataFactory.fillDefaults().grab(true, false).applyTo(text);
	    
	    createTableViewer(comp);
	   
	}
	
	/**
	 * Method responsible for initialize the table viewer object
	 * 
	 * @author Geraldo
	 * 
	 */
	
	public void createTableViewer(Composite parent){
		tableViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		createColumns(tableViewer);
		
		final Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBounds(39, 27, 366, 190);
		table.setVisible(true);
		
		tableViewer.setContentProvider(new ArrayContentProvider());
		try {
			tableViewer.setInput(ModelSource.getInstance(manager.getLaunchConfigurations()).getConfigList());
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
		String[] titles = {"",COLUMN_NAME,COLUMN_TYPE};
		int[] bounds = { 100, 100, 100};
		
		TableViewerColumn colChecked = createTableViewerColumn(titles[0], bounds[0], 0);
		colChecked.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        return "";
		      }
		 });
		
		TableViewerColumn colName = createTableViewerColumn(titles[1], bounds[1], 1);
		colName.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        Configuration c = (Configuration) element;
		        return c.getName();
		      }
		 });
		
		TableViewerColumn colType = createTableViewerColumn(titles[2], bounds[2], 2);
		colType.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		        Configuration c = (Configuration) element;
		        return c.getType();
		      }
		 });
		
		
		
	}
	
	
	public TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber){
		final TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		 final TableColumn column = viewerColumn.getColumn();
		 column.setText(title);
		 column.setWidth(bound);
		 column.setResizable(true);
		 column.setMoveable(true);
		 return viewerColumn;
		
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Composite launch tab";
	}

}
