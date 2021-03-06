package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ui.state.ButtonState;
import ui.state.Checked;
import ui.state.Unchecked;

public class Actions extends JPanel implements ActionListener, Colleague {
	private JButton done;
	private JButton remove;
	
	private Mediator mediator;
	
	private ButtonState currentstate;
	private ButtonState disabled;
	private ButtonState enabled;

	public Actions() {
			
		done = new JButton("Done");
		remove = new JButton("Remove");
		
		this.add(done);
		this.add(remove);

		done.addActionListener(this);
		remove.addActionListener(this);
		
		disabled = new Unchecked(this);
		enabled = new Checked(this);
		
		currentstate = disabled;
	}
	
	public void check() {
		currentstate.check();
	}
	
	public void uncheck() {
		currentstate.uncheck();
	}
	
	public ButtonState getCurrentstate() {
		return currentstate;
	}

	public void setCurrentstate(ButtonState currentstate) {
		this.currentstate = currentstate;
	}


	public ButtonState getDisabled() {
		return disabled;
	}


	public JButton getDone() {
		return done;
	}


	public JButton getRemove() {
		return remove;
	}


	public void setDisabled(ButtonState disabled) {
		this.disabled = disabled;
	}



	public ButtonState getEnabled() {
		return enabled;
	}



	public void setEnabled(ButtonState enabled) {
		this.enabled = enabled;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(done)) {
			mediator.process("done");
		}

		if (e.getSource().equals(remove)) {
			mediator.process("remove");
		}
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

}
