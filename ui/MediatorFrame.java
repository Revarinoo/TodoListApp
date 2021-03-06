package ui;

import java.util.Date;

import ui.decorator.Decorator;
import ui.decorator.Drawable;

import ui.state.Mode;

public class MediatorFrame extends Mediator implements Drawable {

	private TodoFrame todoframe;
	private Mode Mode;
	private Todos todos;
	private Actions actions;
	private TodoInput input;

	public MediatorFrame(TodoFrame todoframe, Todos Todos, Actions Actions, TodoInput Input, Mode mode) {
		this.todoframe = todoframe;
		this.todos = Todos;
		this.actions = Actions;
		this.input = Input;
		this.Mode = mode;
		input.setMediator(this);
		todos.setMediator(this);
		actions.setMediator(this);
		Mode.setMediator(this);
		
	}

	@Override
	public void process(String request) {
		todoframe.toFront();
		todoframe.requestFocus();
		switch (request) {
		case "check":
			actions.check();
			break;

		case "uncheck":
			actions.uncheck();
			break;

		case "done":
			doneTodos();
			todoframe.updateDone(true);
			break;

		case "remove":
			removeTodos();
			break;

		default:
			addTodo(request);
		}
	}
	
	private void addTodo(String text) {
		todos.addTodo(text);
		todoframe.pack();
	}

	private void doneTodos() {
		todos.done();
		todoframe.pack();
	}

	private void removeTodos() {
		todos.remove();
		todoframe.pack();
	}

	@Override
	public void setColor() {
		
	}

	@Override
	public Actions getActions() {
		return actions;
	}

	@Override
	public TodoInput getInput() {
		return input;
	}

	@Override
	public Todos getTodos() {
		return todos;
	}

	@Override
	public void attach(Decorator decorator) {
		todos.attach(decorator);
	}

}
