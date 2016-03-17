package fungui;
import processing.core.*;

public class MenuItem extends ListItem implements PConstants {
	Menu m;
	int ordinal = 0;
	public int alignment = LEFT;
	PFont font;
	int c = 230;
	
	public MenuItem(PApplet p, float ex, float why, String label, int numColumns, float width, int ordinal, Menu menu) {
		super(p, ex, why, label, numColumns, width);
		this.ordinal = ordinal;
		this.m = menu;
		pressed = false;
		font = this.p.createFont("Helvetica", 13);
	}
	
	public MenuItem(PApplet p, float ex, float why, String label, float width, int ordinal, Menu menu, int alignmentDirection) {
		super(p, ex, why, label, 1, width);
		this.ordinal = ordinal;
		this.m = menu;
		font = this.p.createFont("Helvetica", 13);
		pressed = false;
		alignment = alignmentDirection;
	}
	
	public void colorize(int n) {
		this.c = n;
	}
	
	@Override
	public void display() {
		g.pushStyle();
		g.rectMode(CORNER);
		if (clicked()) {
			g.fill(210);
		} else {
			g.fill(c);
		}
		g.noStroke();
		g.rect(x, y, w, h);
		g.popStyle();
		
		selected();
		
	}

	void selected() {
		if (!pressed)
			selected = (clicked()) ? true : false;
		pressed = p.mousePressed;
	}
	
	@Override
	public void text() {
		g.textAlign(alignment, CENTER);
		g.textFont(font);
		g.text(label, (float) (x + w * .5), y);
	}
	
	@Override
	public boolean clicked() {
		return(p.mousePressed && p.mouseX > x && p.mouseY > y && p.mouseX < x + w && p.mouseY < y + 20);
	}
}
