package br.geraldo.composite.ui;



import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import br.geraldo.composite.ui.table.Configuration;

public class CompositeTab extends AbstractLaunchConfigurationTab {

	private Text text;
	private TableViewer tableViewer;
	private static final String COLUMN_NAME = "Name";
	private static final String COLUMN_TYPE = "Type";
	
	
	
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
