package fungui;

import processing.core.PApplet;
import processing.core.PFont;

public class ListItem extends Frame {
	Float r1, r2;
	String label;
	public float wratio, hratio;
	public boolean selected = false;
	public boolean pressed;
	PFont font;
	Display d;
	int numColumns;
	
	float widthLimit;

	float beginningW;
	float beginningH;
	
	public ListItem(PApplet p, float ex, float why, String label, int numColumns, float width) {
		init(p, ex, why, label);
		this.widthLimit = width / numColumns;
	}
	
	public ListItem(PApplet p, float ex, float why, String label, Display d, int numColumns) {
		init(p, ex, why, label);
		this.d = d;
		this.widthLimit = d.w / numColumns;
	}
	
	void init(PApplet p, float ex, float why, String label) {
		this.p = p;
		this.g = p.g;
		this.y = why;
		this.x = ex;
		this.label = label;
		beginningW = p.width;
		beginningH = p.height;
	}
	
	void selected() {
		
	}
	
	public boolean clicked() {
		return(true);
	}
}
