package ui.state;

import java.awt.Color;

import ui.Colleague;
import ui.Mediator;
import ui.decorator.Drawable;

public class Mode implements Colleague {

	private ModeState currentState;
	private ModeState darkState;
	private ModeState lightState;
	private Mediator mediator;
	private int flag = 1;

	public Mode() {
		darkState = new DarkMode(this);
		lightState = new LightMode(this);

		currentState = lightState;
	}

	public void change() {
		
		if (flag % 2 != 0) {
			switchDark();
		}
		else {
			switchLight();
		}
		
		flag++;
	}

	public void switchDark() {
		currentState.toDarkMode((Drawable) mediator, mediator);
	}

	public void switchLight() {
		currentState.toLightMode((Drawable) mediator, mediator);
	}

	public ModeState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(ModeState currentState) {
		this.currentState = currentState;
	}

	public ModeState getDarkState() {
		return darkState;
	}

	public void setDarkState(ModeState darkState) {
		this.darkState = darkState;
	}

	public ModeState getLightState() {
		return lightState;
	}

	public void setLightState(ModeState lightState) {
		this.lightState = lightState;
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}


}
