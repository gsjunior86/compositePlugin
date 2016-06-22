package br.geraldo.composite.ui;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class CompositeTabGroup extends AbstractLaunchConfigurationTabGroup {
	
	public static final String LAUNCH_NAME = "Composite Run";

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		setTabs(new ILaunchConfigurationTab[] {new CompositeTab(), new CommonTab()} );
		
	}
	
	

}
