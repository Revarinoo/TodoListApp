package ui.state;

import ui.Actions;

public class Checked implements ButtonState{
	
	private Actions action;
	
	public Checked(Actions action) {
		this.action = action;
	}

	@Override
	public void check() {
		action.getRemove().setEnabled(true);
		action.getDone().setEnabled(true);
		action.setCurrentstate(action.getDisabled());
	}

	@Override
	public void uncheck() {
		
	}

}
