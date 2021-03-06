package ui.decorator;

import ui.Receiver;

public abstract class Decorator implements Drawable, Receiver {
	
	protected Drawable wrapp;
	
	public Decorator(Drawable wrapp) {
		this.wrapp = wrapp;
	}
	
}
