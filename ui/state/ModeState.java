package ui.state;

import ui.Mediator;
import ui.decorator.Drawable;

public interface ModeState {
	void toDarkMode(Drawable mediator, Mediator med);
	void toLightMode(Drawable mediator, Mediator med);
}
