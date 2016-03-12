package funGUI;

import processing.core.*;

public class ToggleButton extends Button implements PConstants {
	boolean on = false;
	public Timer t;
	PFont font, liFont;
	protected float r;
	String stateOn = "ON";
	String stateOff = "OFF";
	Direction textPosition = Direction.UP;
	boolean pressed = false;

	/**
	 * Makes a ToggleButton object that is toggled on and off, i.e. like a
	 * switch.
	 * 
	 * @param p
	 *            the instance of PAPplet, usually "this"
	 * @param x
	 *            float
	 * @param y
	 *            float
	 */
	public ToggleButton(PApplet p, float x, float y) {
		init(p, x, y);
	}

	/**
	 * The other ToggleButton constructor.
	 * 
	 * @param p
	 *            the instance of PApplet (the Processing sketch), usually
	 *            "this"
	 * @param x
	 *            float
	 * @param y
	 *            float
	 * @param label
	 *            String, the button's descriptive name, i.e. "Display Bunnies."
	 */
	public ToggleButton(PApplet p, float x, float y, String l) {
		init(p, x, y);
		label(l);
	}
	
	public ToggleButton(PApplet p, float x, float y, String l, Direction d) {
		init(p, x, y);
		label(l);
		textPosition = d;
	}
	
	public void label(String l) {
		this.label = l;
	}
	
	public void name(String name) {
		label(name);
	}

	protected void text(float dx, float dy) {
		if (notequals(label, "")) {
			graphics.pushStyle();
			graphics.fill(0);
			graphics.textFont(liFont);
			graphics.textAlign(CENTER);
			graphics.text(label, x + dx, y - dy);
			graphics.popStyle();
		}
	}

	@Override
	protected void display() {
		offset();
		toggle();
	}
	
	protected void offset() {
		graphics.textFont(font);
		float dx = graphics.textWidth(label);
		float dy = 25;
		switch (textPosition) {
		case UP:
			dx = 0;
			dy *= -1;
			break;
		case DOWN:
			dx = 0;
			break;
		case RIGHT:
			dy = 0;
			break;
		case LEFT:
			dx *= -1;
			dy = 0;
			break;
		default:
			break;
		}
		// Draw the background components of the button
		
		// Draw the front components of the button (i.e. the switch, the words
		// On or Off, etc.)
		buttonBase(dx, dy);
		buttonFace(dx, dy);
		text(dx, dy);
	}

	protected void buttonFace(float dx, float dy) {
		graphics.fill(255);
	    graphics.stroke(200);
	    graphics.strokeWeight(3.2f);
	    int a = -1;
	    int b = 1;
	    String text = stateOn;
	    if (!on()) {
	      a *= -1;
	      b *= -1;
	      text = stateOff;
	    }

	    graphics.ellipse(x + dx + a * w2, y + dy, r * 2, r * 2);
	    //shadow
	    graphics.stroke(150);
	    graphics.arc(x + dx + a * w2, y + dy, r * 2, r * 2, rads(60), rads(260));
	    
	    graphics.pushStyle();
	    graphics.fill(255);
	    graphics.textFont(font);
	    graphics.textAlign(CENTER, CENTER);
	    graphics.text(text, ( float ) (x + dx + b * w2 * .5), ( float ) (y + dy - 2.5));
	    graphics.popStyle();
	}

	protected void buttonBase(float dx, float dy) {
		graphics.pushStyle();
		if (on)
			graphics.fill(50, 240, 90);
		else
			graphics.fill(255, 30, 10);

		graphics.stroke(180);
		graphics.strokeWeight(3);
		// The two left sides
		openarc(x - w2 + dx, y + dy, r, HALF_PI, HALF_PI * 3);
		openarc(x + w2 + dx, y + dy, r, HALF_PI * 3, TWO_PI + HALF_PI);
		
		graphics.rectMode(CENTER);
		graphics.rect(x + dx, y + dy, w, w2);
		graphics.noStroke();
		float offset = (float) (w2 * 0.90);
		//float shrink = (float) 3.75;
		float ychng = (float) .5;
		openarc(( float ) (x + dx - offset), ( float ) (y + dy + ychng), ( float ) (r * .85), rads(60), rads(300));
		openarc(( float ) (x + dx + offset - .05), ( float ) (y + dy + ychng), ( float ) (r * .89), rads(245), rads(500));
		graphics.popStyle();
	}

	@Override
	protected void style() {
	
	}

	/**
	 * If the button is clicked, the button becomes on if it was off and off if
	 * it was on.
	 */
	protected void toggle() {
		if (clicked()) {
			if (pressed && t.done()) on = !on;
			t.reset();
		} else {
			pressed = p.mousePressed;
		}
	}

	protected void arch(float x, float y, float r, float s, float e) {
		graphics.arc(x, y, r * 2, r * 2, s, e);
	}

	protected void openarc(float x, float y, float r, float s, float e) {
		graphics.arc(x, y, r * 2, r * 2, s, e, OPEN);
	}
	
	@Override
	public float w() {
		float dx = 25;
		float dy = 25;
		if (textPosition == Direction.DOWN || textPosition == Direction.UP){
			return(x);
		} else if (textPosition == Direction.LEFT) {
			return(( float ) (x - dx - .5 * graphics.textWidth(label)));
		} else {
			return(( float ) (x + dx + .5 * graphics.textWidth(label)));
		}
	}
	
	@Override
	public float h() {
		float dx = 25;
		float dy = 25;
		if (textPosition == Direction.LEFT || textPosition == Direction.RIGHT){
			return(y);
		} else if (textPosition == Direction.UP) {
			return(( float ) (y - dy));
		} else {
			return(( float ) (y + dy));
		}
	}
	
	public float adjustedX() {
		graphics.textFont(font);
		float dx = graphics.textWidth(label);
		float dy = 25;
		switch (textPosition) {
		case UP:
			dx = 0;
			dy *= -1;
			break;
		case DOWN:
			dx = 0;
			break;
		case RIGHT:
			dy = 0;
			break;
		case LEFT:
			dx *= -1;
			dy = 0;
			break;
		default:
			break;
		}
		return(x + dx);
	}
	
	public float adjustedY() {
		graphics.textFont(font);
		float dx = graphics.textWidth(label);
		float dy = 25;
		switch (textPosition) {
		case UP:
			dx = 0;
			dy *= -1;
			break;
		case DOWN:
			dx = 0;
			break;
		case RIGHT:
			dy = 0;
			break;
		case LEFT:
			dx *= -1;
			dy = 0;
			break;
		default:
			break;
		}
		
		return(y + dy);
	}
	
	@Override
	public boolean clicked() {
		graphics.textFont(font);
		float dx = graphics.textWidth(label);
		float dy = 25;
		switch (textPosition) {
		case UP:
			dx = 0;
			dy *= -1;
			break;
		case DOWN:
			dx = 0;
			break;
		case RIGHT:
			dy = 0;
			break;
		case LEFT:
			dx *= -1;
			dy = 0;
			break;
		default:
			break;
		}
		if (p.mousePressed) pressed = true;
		return(super.clicked(dx, dy));
	}

	protected float rads(float degrees) {
		return (( float ) ((degrees / 180.0) * PI));
	}

	public boolean on() {
		return(on);
	}

	protected boolean notequals(String s1, String s2) {
		return (!(s1.equals(s2)));
	}

	/**
	 * Enacts all of the basic functionality of the two constructors.
	 * 
	 * @param x
	 *            float, the x-coordinate of the button's center
	 * @param y
	 *            float, the y-coordinate of the button's center
	 */
	private void init(PApplet p, float x, float y) {
		this.p = p;
		this.x = x;
		this.y = y;
		t = new Timer(60, p);
		t.reset();
		w = 40.0f;
		h = 20;
		r = 10.0f;
		w2 = 20.0f;
		font = p.createFont("Optima-Bold", 17);
		liFont = p.createFont("Helvetica-Regular", 18);
		graphics = p.g;
	}
}
