package ui;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Todos extends JPanel implements Observer, Colleague, Info {
	
	private Vector<Todo> todos;
	private Mediator mediator;
	private Vector<Receiver> observers;
	
	public Todos() {
		this.observers = new Vector<>();
		this.todos = new Vector<>();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		displayTodos();
	}
	
	public Vector<Todo> getTodos() {
		return todos;
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public void addTodo(String text) {
		Todo todo = new Todo(text);
		todo.attach(this);
		todos.add(todo);
		
		displayTodos();
	}

	public void done() {
		Vector<Todo> newTodos = new Vector<>();
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				continue;
			}
			newTodos.add(todo);
		}
		this.todos = newTodos;
		mediator.process("uncheck");
		displayTodos();
	}

	public void remove() {
		Vector<Todo> newTodos = new Vector<>();
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				continue;
			}
			newTodos.add(todo);
		}
		this.todos = newTodos;
		mediator.process("uncheck");
		displayTodos();
	}

	private void displayTodos() {
		removeAll();
		for (Todo todo : todos) {
			this.add(todo);
			broadcast(todo);
		}
	}

	@Override
	public void update(boolean check) {
		if(check) {
			mediator.process("check");
		}
		else {
			mediator.process("uncheck");
			for (Todo todo : todos) {
				if (todo.isChecked()) {
					mediator.process("check");
					break;
				}
			}
		}
	}

	@Override
	public void attach(Receiver rec) {
		observers.add(rec);
	}

	@Override
	public void broadcast(Todo todo) {
		for(Receiver r : observers) {
			r.update(todo);
		}
	}
	
}
