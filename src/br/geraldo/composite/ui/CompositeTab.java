package br.geraldo.composite.ui;



import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class CompositeTab extends AbstractLaunchConfigurationTab {

	private Text text;
	
	
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
