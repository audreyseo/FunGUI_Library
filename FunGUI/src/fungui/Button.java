package fungui;

import processing.core.*;
import processing.core.PGraphics;

/**
 * The Button class serves as the template for all button-type
 * objects. Events such as mouseClick and draw are handled here.
 * However, this class is abstract, and thus never implemented.
 * If you want a button, try ToggleButton, RectButton, etc. instead.
 * @author Audrey Seo
 *
 */
public abstract class Button extends Frame implements PConstants {
	public String label;
	public float w2, h2;

	public Button() {
		// nothing here
	}

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

	public void color(int n) {
		c = new int[1];
		c[0] = n;
	}

	public void color(int... n) {
		// The color array is in the following format:
		// inner fill, inner stroke, outer fill, outer stroke, font fill
		c = new int[n.length];
		for (int i = 0; i < c.length; i++) {
			c[i] = n[i];
		}
	}

	public boolean clicked() {
		return (p.mousePressed && p.mouseX < x + w * .5
				&& p.mouseX > x - w * .5 && p.mouseY < y + h * .5 && p.mouseY > y
				- h * .5);
	}

	public boolean clicked(float dx, float dy) {
		// p.println("MX1: " + (x + dx + w * .5));
		// p.println("MX2: " + (x + dx - w * .5));
		// p.println("MY1: " + (y + dy + h * .5));
		// p.println("MY2: " + (y + dy - h * .5));
		// p.println("MP:  " + p.mousePressed);
		return (p.mousePressed && (p.mouseX < x + dx + w * .5)
				&& (p.mouseX > x + dx - w * .5) && (p.mouseY < y + dy + h * .5) && (p.mouseY > y
				+ dy - h * .5));
	}
}
