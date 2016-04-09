package funGUI;
import processing.core.*;
import processing.event.KeyEvent;

public class Message extends Frame {
	protected static final char ONKEY = ' ';
	protected static final char OFFKEY = 's';
	public int fillc;
	public int strokec;
	protected boolean on = false;
	
	public Message(PApplet p, float x, float y, float w, float h) {
		this.p = p;
		this.g = p.g;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		fillc = g.color(255, 255, 255);
		strokec = g.color(0);
	}
	
	@Override
	protected void display() {
		g.pushStyle();
		g.rectMode(CENTER);
		g.fill(fillc);
		g.stroke(strokec);
		g.strokeWeight(2);
		g.rect(x, y, w, h);
		g.popStyle();
	}
	
	public void keyEvent(KeyEvent e) {
		if (e.getKey() != CODED) {
			switch(e.getKey()) {
			case ONKEY:
				if (!on) on = true;
				break;
			case OFFKEY:
				if (on) on = false;
				break;
			default:

			}
		}
	}
	
	public boolean on() {
		return(on);
	}
	
	@Override
	public String returnName() {
		return("Message");
	}

}
