package ui.state;

import ui.Mediator;
import ui.decorator.DarkModeDecorator;
import ui.decorator.Drawable;

public class DarkMode implements ModeState{
	
	private Mode mode;
	
	public DarkMode(Mode mode) {
		this.mode = mode;
	}

	@Override
	public void toDarkMode(Drawable mediator, Mediator med) {
		mediator = new DarkModeDecorator(mediator);
		mediator.setColor();
		med.attach(new DarkModeDecorator(mediator));
		mode.setCurrentState(mode.getLightState());
	}

	@Override
	public void toLightMode(Drawable mediator, Mediator med) {
		// TODO Auto-generated method stub
		
	}


}
