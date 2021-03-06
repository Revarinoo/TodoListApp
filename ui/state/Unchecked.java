package ui.state;

import ui.Actions;

public class Unchecked implements ButtonState{
	
	private Actions action;
	
	public Unchecked(Actions action) {
		this.action = action;
	}

	@Override
	public void check() {
		
	}

	@Override
	public void uncheck() {
		action.getRemove().setEnabled(false);
		action.getDone().setEnabled(false);
		action.setCurrentstate(action.getEnabled());
	}

}
