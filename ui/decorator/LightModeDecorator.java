package ui.decorator;

import java.awt.Color;

import ui.Actions;
import ui.Todo;
import ui.TodoInput;
import ui.Todos;

public class LightModeDecorator extends Decorator {

	public LightModeDecorator(Drawable wrapp) {
		super(wrapp);
	}

	@Override
	public void setColor() {
		this.wrapp.getActions().setBackground(null);
		this.wrapp.getInput().setBackground(null);
		this.wrapp.getTodos().setBackground(null);
		for(Todo t : this.wrapp.getTodos().getTodos()) {
			t.setBackground(null);
			t.getCheckbox().setBackground(null);
			t.getLabel().setForeground(null);
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
		todo.setBackground(null);
		todo.getCheckbox().setBackground(null);
		todo.getLabel().setForeground(null);
	}

}
