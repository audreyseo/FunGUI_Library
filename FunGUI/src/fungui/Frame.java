package fungui;

import processing.core.*;

public abstract class Frame {
	public enum ColorApp {
		INNER_FILL, OUTER_FILL, INNER_STROKE, OUTER_STROKE, FONT_FILL;

	}

	public int[] c;
	protected PApplet p;
	public float x, y;
	public float w, h;
	protected PGraphics graphics = new PGraphics();

	public Frame() {
		// BLANK
	}

	protected void display() {
		// Put any shape functions in here
	}

	protected void style() {
		// Put any style-related functions in here
	}

	protected void text() {
		// Put any text calls in here
	}

	public void draw() {
		// Runs all of the shape-drawing functions
		graphics.pushStyle();
		style();
		display();
		text();
		graphics.popStyle();
	}

	protected void col(ColorApp app) {
		switch (app) {
		case INNER_FILL:
			if (col(0))
				graphics.fill(c[0]);
			break;
		case INNER_STROKE:
			if (col(1))
				graphics.stroke(c[1]);
			break;
		case OUTER_FILL:
			if (col(2))
				graphics.fill(c[2]);
			break;
		case OUTER_STROKE:
			if (col(3))
				graphics.stroke(c[3]);
			break;
		case FONT_FILL:
			if (col(4))
				graphics.fill(c[4]);
			break;
		default:
			break;
		}
	}

	public boolean col(int n) {
		return (c.length > (n + 1) && c[n] >= 0);
	}

	public float w() {
		return (w);
	}

	public float h() {
		return (h);
	}
}
