package funGUI;
import processing.core.*;
import processing.core.PGraphics;

public abstract class Button extends Frame implements PConstants {
	public String label;
	public float w2, h2;
	
	public Button() {
		//nothing here
	}
	
	@Override
	protected void display() {
		//Put any shape functions in here 
	}
	
	@Override
	protected void style() {
		//Put any style-related functions in here
	}
	
	@Override
	protected void text() {
		//Put any text calls in here
	}
	
	@Override
	public void draw() {
		// Runs all of the shape-drawing functions
		graphics.pushStyle();
		style();
		display();
		text();
		graphics.popStyle();
	}
	
	public void color(int n) {
		c = new int [1];
		c[0] = n;
	}
	
	public void color(int... n) {
		//	The color array is in the following format:
		//	inner fill, inner stroke, outer fill, outer stroke, font fill
		c = new int [n.length];
		for (int i = 0; i < c.length; i++) {
			c[i] = n[i];
		}
	}
	
	public boolean clicked() {
		return(p.mousePressed && p.mouseX < x + w * .5 && p.mouseX > x - w * .5 && p.mouseY < y + h * .5 && p.mouseY > y - h * .5);
	}
}
