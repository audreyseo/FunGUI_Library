package fungui;
import processing.core.*;


public class Choice extends Option implements PConstants {
	boolean pressed = false;
	
	public Choice(PApplet p, float ex, float why, String label, Display d, int numColumns) {
		super(p, ex, why, label, d, numColumns);
	}

	@Override
	public void shapeDisplay(float width) {
		g.pushStyle();
		g.noStroke();
		g.fill(220, 220, 220);
		g.rectMode(CENTER);
		g.rect(x * wratio, y * hratio, width, width);
		g.popStyle();
	}

	@Override
	public void selectionDisplay() {
		if (selected) {
			g.pushStyle();
			g.stroke(90);
			g.strokeWeight(5);
			g.line(x * wratio, y * hratio, (x - 5) * wratio, (y - 5) * hratio);
			g.line(x * wratio, y * wratio, (x + 5) * wratio, (y - 20) * hratio);
			g.popStyle();
		}
	}
	
	@Override
	public void selected() {
		if (clicked() && !pressed) selected = !selected;
		pressed = p.mousePressed;
	}
}
