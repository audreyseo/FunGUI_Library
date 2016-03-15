package fungui;
import processing.core.*;
public class Option extends Frame implements PConstants {
	String label;
	public float x, y, r1, r2;
	public float wratio, hratio;
	public boolean selected = false;
	PFont font;
	Display d;
	int numColumns;

	float beginningW;
	float beginningH;

	Option(PApplet p, float ex, float why, String label, Display d, int numColumns) {
		this.p = p;
		this.g = p.g;
		this.d = d;
		x = ex;
		y = why;
		this.label = label;
		r1 = (float) 10.0;
		r2 = r1 + 5;
		wratio = (float) 1.0;
		hratio = (float) 1.0;
		this.numColumns = numColumns;
		font = p.createFont("FZLTXHK--GBK1-0", 200, true);
		beginningW = p.width;
		beginningH = p.height;
	}

	void update() {
		wratio = (float) (p.width / beginningW);
		hratio = (float) (p.height / beginningH);
	}
	
	@Override
	public void display() {
		update();

		g.noStroke();
		g.fill(220, 220, 220);
		shapeDisplay(r2 * wratio);
		g.fill(90, 90, 90);

		selected();

		selectionDisplay();


		g.fill(0);
		g.textAlign(LEFT, CENTER);
		g.textFont(font, limitFont(font, 12, label, (float) ((d.w() / numColumns) / 1.25)));
		g.text(label, wratio * (x + 20), hratio * y);
	}
	
	public void selectionDisplay() {
		if (selected) {
			shapeDisplay(radius());
		}
	}
	
	public void shapeDisplay(float radius) {
		g.ellipse(x * wratio, y * hratio, radius, radius);
	}

	void selected() {
		if (!selected)
			selected = (clicked()) ? true : false;
	}

	float radius() {
		return(r1 * wratio + PApplet.constrain((float) ((r2 - r1) * wratio * .5), 0f, (float) ( (r2 - r1) * .5) ));
	}

	public boolean clicked() {
		return(p.mousePressed && (p.mouseX < wratio * (x + r2) && p.mouseX > wratio * (x - r2)) && (p.mouseY < hratio * (y + r2) && p.mouseY > hratio * (y - r2)));
	}
}
