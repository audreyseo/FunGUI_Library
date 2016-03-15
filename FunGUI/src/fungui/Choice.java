package fungui;
import processing.core.*;


public class Choice extends Option {
	
	public Choice(PApplet p, float ex, float why, String label, Display d, int numColumns) {
		super(p, ex, why, label, d, numColumns);
	}

	@Override
	public void shapeDisplay(float width) {
		g.rect(x * wratio, y * wratio, width, width);
	}

	@Override
	public void selectionDisplay() {
		if (selected) {
			g.line(x * wratio, y * wratio, (x - 5) * wratio, (y - 10) * hratio);
			g.line(x * wratio, y * wratio, (x + 5) * wratio, (y - 20) * hratio);
		}
	}
}
