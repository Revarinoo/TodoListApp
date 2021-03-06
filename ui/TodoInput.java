package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TodoInput extends JPanel implements ActionListener, Colleague {
	
	private JTextField text;
	private JButton add;
	private Mediator mediator;

	public TodoInput() {

		text = new JTextField(20);
		add = new JButton("Add");

		this.add(text);
		this.add(add);
		
		add.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!e.getSource().equals(add)) {
			return;
		}

		String todoText = this.text.getText();
		mediator.process(todoText);
		
		this.text.setText("");
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
}
