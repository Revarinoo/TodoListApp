package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Todo extends JPanel implements Observable {
	private Border border;
	private JLabel label;
	
	public JLabel getLabel() {
		return label;
	}

	public JCheckBox getCheckbox() {
		return checkbox;
	}

	private JCheckBox checkbox;
	
	private Vector<Observer> observers;
	
	public Todo(String text) {
		this.setPreferredSize(new Dimension(350, 30));

		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);

		this.setLayout(new BorderLayout());

		checkbox = new JCheckBox();
		this.add(checkbox, BorderLayout.WEST);

		label = new JLabel(text);
		this.add(label, BorderLayout.CENTER);
		
		observers = new Vector<>();
		ActionListener actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected) {
					broadcast(true);
				}
				else {
					broadcast(false);
				}
			}
		};
		checkbox.addActionListener(actionListener);

	}

	public boolean isChecked() {
		return checkbox.isSelected();
	}


	@Override
	public void attach(Observer obs) {
		this.observers.add(obs);
		
	}

	@Override
	public void broadcast(boolean check) {
		for (Observer obs : observers) {
			obs.update(check);
		}
	}

}
