package funGUI;
import processing.core.*;

/**
 * The Choice class comprises a checkbox, which is implemented by the ChoiceList class as the checkboxes in a list.
 * As on the web, the checkboxes are not mutually exclusive, and all or none can be marked.
 * @author audrey
 */
public class Choice extends Option implements PConstants {
	
	/**
	 * Constructor of the Choice class
	 * @param p				PApplet, the parent of the sketch (usually "this")
	 * @param ex			float, the x-coordinate of the checkbox
	 * @param why			float, the y-coordinate of the checkbox
	 * @param label			String, the text that floats to the right of the checkbox
	 * @param d				Display, the display that contains the checkboxes
	 * @param numColumns	int, the number of columns that the choicelist comprises
	 */
	public Choice(PApplet p, float ex, float why, String label, Display d, int numColumns) {
		super(p, ex, why, label, d, numColumns);
	}
	
	
	@Override
	public void record(String s) {
		if (testing) {
			PApplet.println("Choice: " + s);
		}
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
	
	/**
	 * Returns whether or not the checkbox has been clicked
	 * @return	boolean, true or false
	 */
	@Override
	public boolean clicked() {
		return(p.mousePressed && (p.mouseX < wratio * (x + r2 * .5) && p.mouseX > wratio * (x - r2 * .5)) && (p.mouseY < hratio * (y + r2 * .5) && p.mouseY > hratio * (y - r2 * .5)));
	}
}
