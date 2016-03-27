package funGUI;

import processing.core.*;

/**
 * A window is what a display should be, except that a display is
 * rarely used as is. The window contains information and widgets,
 * and you can choose whether the widget is centered or left-
 * aligned or whatever you wish.
 * @author audrey
 *
 */
public class Window extends Display {
	float horizontalMargin = 2;
	float verticalMargin = 2;
	PFont font;
	
	/**
	 * Constructor for the Window class.
	 * @param p						PApplet, the parent of the sketch, usually "this"
	 * @param x						float, x-coordinate of center of window
	 * @param y						float, y-coordinate of center of window
	 * @param w						float, width of the window
	 * @param h						float, height of the window
	 * @param horizontalMargin		float, basically the amount of area to keep clear in the x-direction along the edges
	 * @param verticalMargin		float, the amount of area to keep clear in the y-direction along the edges
	 */
	public Window(PApplet p, float x, float y, float w, float h, float horizontalMargin, float verticalMargin) {
		super(x, y, w, h);
		this.p = p;
		this.g = this.p.g;
		this.horizontalMargin = horizontalMargin;
		this.verticalMargin = verticalMargin;
	}
	
	/**
	 * Constructor for the Window class.
	 * @param p						PApplet, the parent of the sketch, usually "this"
	 * @param x						float, x-coordinate of center of window
	 * @param y						float, y-coordinate of center of window
	 * @param w						float, width of the window
	 * @param h						float, height of the window
	 */
	public Window(PApplet p, float x, float y, float w, float h) {
		super(x, y, w, h);
		this.p = p;
		this.g = this.p.g;
	}
	
	@Override
	protected void style() {
		g.stroke(30);
		g.fill(255);
	}
	
	@Override
	protected void display() {
		g.rect(x(), y(), w(), h());
	}
	
	@Override
	protected void text() {
		g.fill(30);
		g.text(text, x(), y());
	}
	
	public void assignText(String s) {
		this.text = s;
	}
	
	float innerWidth() {
		return(w - 2 * horizontalMargin);
	}
	
	float innerHeight() {
		return(h - 2 * verticalMargin);
	}
}
