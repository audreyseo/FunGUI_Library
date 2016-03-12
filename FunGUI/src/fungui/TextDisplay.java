package fungui;

public class TextDisplay extends Display {

	public TextDisplay(String txt, String header, float x, float y, float w,
			float h) {
		text = txt;
		headline = header;
		init(x, y, w, h);
	}

	@Override
	protected void display() {
		// Put any shape functions in here
	}

	@Override
	protected void style() {
		// Put any style-related functions in here
	}

	@Override
	protected void text() {
		// Put any text calls in here
	}

	@Override
	public void draw() {
		// Runs all of the shape-drawing functions
		g.pushStyle();
		style();
		display();
		text();
		g.popStyle();
	}

	public void init(float x, float y, float w, float h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
}
