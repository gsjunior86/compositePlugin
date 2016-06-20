package br.geraldo.composite.delegate;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import br.geraldo.composite.CompositePlugin;

public class CompositeDelegate implements ILaunchConfigurationDelegate{

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		List<ILaunchConfiguration> listConfig = CompositePlugin.getConfigurations();
		
		for(ILaunchConfiguration ilc: listConfig){
			ilc.launch(mode, monitor);
		}
		
//		configuration.launch(mode, monitor);
		
	}

	

}
