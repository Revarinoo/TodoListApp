package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JFrame;

import ui.state.DarkMode;
import ui.state.LightMode;
import ui.state.Mode;

public class TodoFrame extends JFrame implements KeyListener, Runnable {
	private TodoInput todoInput;
	private Todos todos;
	private Actions actions;
	private int count = 0;
	private Mediator mediator;
	private Mode mode;

	public TodoFrame() {
		todoInput = new TodoInput();
		actions = new Actions();
		mode = new Mode();
		todos = new Todos();
		mediator = new MediatorFrame(this, todos, actions, todoInput, mode);
		mediator.process("uncheck");
		
		createGUI();

	}

	private void createGUI() {
		this.setTitle("Done: " + count);
		this.add(todoInput, BorderLayout.NORTH);
		this.add(todos, BorderLayout.CENTER);
		this.add(actions, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
		this.addKeyListener(this);
		this.toFront();
		this.requestFocus();
	}

	public void updateDone(boolean check) {
		if (check) {
			count++;
			this.setTitle("Done: " + count);
		}
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == 'N') {
			mode.change();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void run() {
		boolean pagi = false;
		boolean malam = false;
		mode.switchLight();
		while(true) {
			if((LocalDateTime.now().getHour() >= 18 || LocalDateTime.now().getHour() < 6) && !malam) {
				mode.change();
				malam = true;
			}
			else if(LocalDateTime.now().getHour() >= 6 && (mode.getCurrentState() instanceof DarkMode) && !pagi){
				mode.switchLight();
				pagi = true;
			}
		}
	}


}
