package br.geraldo.composite.ui.table;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

public class ModelSource {
	
	private List<Configuration> configList;
	
	private ModelSource(ILaunchConfiguration[] iLaunchConfigurations){
		
		configList = new ArrayList<Configuration>();
		
		for(ILaunchConfiguration launchConfiguration: iLaunchConfigurations){
			try {
				configList.add(new Configuration(false,launchConfiguration.getName(),launchConfiguration.getType().getName()));
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static ModelSource getInstance(ILaunchConfiguration[] iLaunchConfigurations){
		return new ModelSource(iLaunchConfigurations);
	}

	public List<Configuration> getConfigList() {
		return configList;
	}
	

}
