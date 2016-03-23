package fungui;

import processing.core.*;

public class DropDownSubMenuItem extends DropDownMenuItem {
	Menu m;
	public DropDownSubMenuItem(PApplet p, float ex, float why, String label, int numColumns, float width, int ordinal, Menu menu, String [] optionLabels) {
		super(p, ex, why, label, numColumns, width, ordinal, menu);
		m = new Menu(p, x() + w, y(), optionLabels);
	}

	public void draw(boolean selected, boolean drawing) {
		g.pushStyle();
		display(selected, drawing);
		text();
		g.popStyle();
	}
	
	
	protected void display(boolean okayToSelect, boolean okayToDraw) {
		g.pushStyle();
		g.rectMode(CORNER);
		if (selected && okayToSelect) {
			if (okayToDraw) m.draw();
			g.fill(210);
		} else {
			g.fill(c);
		}
		g.stroke(0);
		itemDisplay();
		g.popStyle();

		if (okayToSelect) {
			selected();
		}

	}
	
	public void deselect() {
		this.selected = false;
		this.m.selectedOption = -1;
		for (int i = 0; i < m.items.length; i++) {
			m.items[i].selected = false;
		}
	}
	
	public boolean selectionComplete() {
		return(selected && this.m.selectedOption >= 0);
	}
	
	protected void itemDisplay() {
		if (!selected) {
			g.rect(x, y(), w, h);
			
		} else {
			float point = 5;
			g.beginShape();
			g.vertex(x, y());
			g.vertex(x + w, y());
			g.vertex(x + w + point, y() + h * .5f);
			g.vertex(x + w, y() + h);
			g.vertex(x, y() + h);
			g.endShape(CLOSE);
		}
	}
}
