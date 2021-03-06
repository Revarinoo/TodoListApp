package ui;

import ui.decorator.Decorator;

public abstract class Mediator {
	
	public abstract void process(String request);
	public abstract void attach(Decorator decorator);
	
}
