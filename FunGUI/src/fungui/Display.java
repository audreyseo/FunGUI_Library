package fungui;

import processing.core.*;

public abstract class Display extends Frame {
	String text, headline;

	@Override
	protected void display() {
		// Put any shape functions in here
	}

	@Override
	protected void style() {
		// Put any style-related functions in here
	}

	@Override
	protected void text() {
		// Put any text calls in here
	}

	@Override
	public void draw() {
		// Runs all of the shape-drawing functions
		g.pushStyle();
		style();
		display();
		text();
		g.popStyle();
	}

}
