package ui.state;

import ui.Colleague;
import ui.Mediator;
import ui.decorator.Drawable;
import ui.decorator.LightModeDecorator;

public class LightMode implements ModeState{

	private Mode mode;
	
	public LightMode(Mode mode) {
		this.mode = mode;
	}
	
	@Override
	public void toDarkMode(Drawable mediator, Mediator med) {
		
		
	}

	@Override
	public void toLightMode(Drawable mediator, Mediator med) {
		mediator = new LightModeDecorator(mediator);
		mediator.setColor();
		med.attach(new LightModeDecorator(mediator));
		mode.setCurrentState(mode.getDarkState());
	}


}
