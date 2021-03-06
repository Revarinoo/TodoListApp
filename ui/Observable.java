package ui;

public interface Observable {
	void attach(Observer obs);
	void broadcast(boolean check);
}
