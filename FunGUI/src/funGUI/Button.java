package funGUI;
import processing.core.*;
import processing.core.PGraphics;

public abstract class Button implements PConstants {
	protected PApplet p;
	public int c;
	public String label;
	public float x, y, w, h;
	public float w2, h2;
	PGraphics graphics = new PGraphics();
	
	public Button() {
		//nothing here
	}
	
	protected void display() {
		//Put any shape functions in here 
	}
	
	protected void style() {
		//Put any style-related functions in here
	}
	
	protected void text() {
		//Put any text calls in here
	}
	
	public void draw() {
		// Runs all of the shape-drawing functions
		graphics.pushStyle();
		style();
		display();
		text();
		graphics.popStyle();
	}
	
	public boolean clicked() {
		return(p.mousePressed && p.mouseX < x + w * .5 && p.mouseX > x - w * .5 && p.mouseY < y + h * .5 && p.mouseY > y - h * .5);
	}
	
	
}
