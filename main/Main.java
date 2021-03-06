package main;

import ui.TodoFrame;

public class Main {
	public static void main(String[] args) {
		TodoFrame frame = new TodoFrame();
		Thread t1 = new Thread(frame);
		t1.start();
	}
}
