package br.geraldo.composite.ui.table;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.swt.graphics.Image;

import br.geraldo.composite.ui.CompositeTabGroup;

public class ModelSource {
	
	private List<Configuration> configList;
	
	private ModelSource(ILaunchConfiguration[] iLaunchConfigurations){
		
		configList = new ArrayList<Configuration>();
		
		for(ILaunchConfiguration launchConfiguration: iLaunchConfigurations){
			
			try {
				if(launchConfiguration.getType().getName().equals(CompositeTabGroup.LAUNCH_NAME)){
					continue;
				}
				Image image = DebugUITools.getImage(launchConfiguration.getType().getIdentifier());
				configList.add(new Configuration(launchConfiguration.getMemento(),image,launchConfiguration.getName(),launchConfiguration.getType().getName()));
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
