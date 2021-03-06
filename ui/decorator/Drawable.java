package ui.decorator;

import java.awt.Color;

import ui.Actions;
import ui.TodoInput;
import ui.Todos;

public interface Drawable {
	void setColor();
	Actions getActions();
	TodoInput getInput();
	Todos getTodos();
}
