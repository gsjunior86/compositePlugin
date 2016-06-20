package br.geraldo.composite.ui.table;

public class Configuration {

	
	private boolean checked;
	private String name;
	private String type;
	
	public Configuration(boolean checked, String name, String type){
		this.checked = checked;
		this.name = name;
		this.type = type;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return (((Configuration)obj).getName().equals(this.name) && ((Configuration)obj).getType().equals(this.type)) ;
	}
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
