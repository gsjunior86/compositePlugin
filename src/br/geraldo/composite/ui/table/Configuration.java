package br.geraldo.composite.ui.table;

import org.eclipse.swt.graphics.Image;

public class Configuration {

	
	private String memento;
	private Image image;
	private String name;
	private String type;
	
	public Configuration(String memento,Image image, String name, String type){
		this.memento = memento;
		this.setImage(image);
		this.name = name;
		this.type = type;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return (((Configuration)obj).getName().equals(this.name) && ((Configuration)obj).getType().equals(this.type)) ;
	}

	public String getMemento() {
		return memento;
	}


	public void setMemento(String memento) {
		this.memento = memento;
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


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}
	
	

}
