package br.geraldo.composite.ui.table;

import java.util.ArrayList;
import java.util.List;

public class ModelSource {
	
	private List<Configuration> configList;
	
	private ModelSource(){
		configList = new ArrayList<Configuration>();
		configList.add(new Configuration(false,"Java","Java Application"));
		configList.add(new Configuration(false,"Apache","Server"));
	}
	
	public static ModelSource getInstance(){
		return new ModelSource();
	}

	public List<Configuration> getConfigList() {
		return configList;
	}
	

}
