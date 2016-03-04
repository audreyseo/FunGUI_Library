package funGUI;
import processing.core.*;

public class Slider implements PConstants {
	float x, y, w, h;

	float percent;

	float min;
	float max;
	String label;
	PFont f;

	Slider(float x, float y, float min, float max) {
		init(x, y, min, max);
	}

	Slider(String label, float x, float y, float min, float max) {
		this.label = label;
		init(x, y, min, max);
	}

	Slider(String label, float x, float y, float min, float max, float initial) {
		this.label = label;
		init(x, y, min, max);
		this.percent = PApplet.constrain( PApplet.map(initial, min, max, 0, 1), 0, 1 );
	}

	void draw() {
		txt();
		bg();
		slider();
		slide();
	}

	void txt() {
		if (label != null) {
			pushStyle();
			textFont(f);
			textAlign(CENTER, CENTER);
			fill(0);
			text(label, x, y - 25);
			popStyle();
		}
	}

	void bg() {
		pushStyle();
		rectMode(CENTER);
		fill(255);
		stroke(30);
		rect(x, y, w, h);
		arc(x - w * .49, y, h, h, HALF_PI, HALF_PI * 3, OPEN);
		arc(x + w * .5, y, h, h, HALF_PI * 3, HALF_PI * 5, OPEN);
		float xi = x - w * .45;
		float step = ((x + w * .45) - xi) / 10;
		for (int i = 0; i < (w * .9) / step + 1; i++) {
			fill(30);
			strokeWeight(1.5);
			if (i % 2 == 1)
				strokeWeight(.5);
			rect(xi + step * i, y, 2, 10);
		}
		strokeWeight(3);
		line(xi, y, xi + step * 10, y);
		popStyle();
	}

	void slider() {
		pushStyle();
		float xs = x - w * .45 + percent * (w * .9);
		rectMode(CENTER);
		fill(255);
		stroke(0);
		rect(xs, y, 7, 15);
		popStyle();
	}

	void slide() {
		float xs = x - w * .45 + percent * (w * .9);
		if (mousePressed && mouseX > x - .45 * w && mouseX < x + .45 * w
				&& mouseY > y - 7.5 && mouseY < y + 7.5) {
			percent = constrain(map(mouseX, x - .45 * w, x + .45 * w, 0, 1), 0,
					1);
		}
	}

	boolean slid() {
		return (mousePressed && mouseX > x - .45 * w && mouseX < x + .45 * w
				&& mouseY > y - 7.5 && mouseY < y + 7.5);
	}

	float p() {
		return (percent * (min + (max - min)));
	}

	void init(float x, float y, float min, float max) {
		this.x = x;
		this.y = y;
		this.min = min;
		this.max = max;

		this.percent = .5;
		this.w = 150;
		this.h = 20;
		f = createFont("Georgia", 20, true);
	}

}
