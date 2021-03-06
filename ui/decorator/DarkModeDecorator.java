package ui.decorator;

import java.awt.Color;

import ui.Actions;
import ui.Todo;
import ui.TodoInput;
import ui.Todos;

public class DarkModeDecorator extends Decorator {

	public DarkModeDecorator(Drawable wrapp) {
		super(wrapp);
	}

	@Override
	public void setColor() {
		this.wrapp.getActions().setBackground(Color.black);
		this.wrapp.getInput().setBackground(Color.black);
		this.wrapp.getTodos().setBackground(Color.black);
		for(Todo t : this.wrapp.getTodos().getTodos()) {
			t.setBackground(Color.black);
			t.getCheckbox().setBackground(Color.black);
			t.getLabel().setForeground(Color.white);
		}
	}

	@Override
	public Actions getActions() {
		return this.wrapp.getActions();
	}

	@Override
	public TodoInput getInput() {
		return this.wrapp.getInput();
	}

	@Override
	public Todos getTodos() {
		return this.wrapp.getTodos();
	}

	@Override
	public void update(Todo todo) {
		todo.setBackground(Color.black);
		todo.getCheckbox().setBackground(Color.black);
		todo.getLabel().setForeground(Color.white);
	}

}
