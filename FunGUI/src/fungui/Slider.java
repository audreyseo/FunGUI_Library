package fungui;

import processing.core.*;

public class Slider implements PConstants {
	float x, y, w, h;

	float percent;

	float min;
	float max;
	String label;
	PFont f;
	PGraphics g;
	PApplet p;

	public Slider(PApplet p, float x, float y, float min, float max) {
		init(p, x, y, min, max);
	}

	public Slider(PApplet p, String label, float x, float y, float min,
			float max) {
		this.label = label;
		init(p, x, y, min, max);
	}

	public Slider(PApplet p, String label, float x, float y, float min,
			float max, float initial) {
		this.label = label;
		init(p, x, y, min, max);
		this.percent = PApplet.constrain(PApplet.map(initial, min, max, 0, 1),
				0, 1);
	}

	public void draw() {
		txt();
		bg();
		slider();
		slide();
	}

	void txt() {
		if (label != null) {
			g.pushStyle();
			g.textFont(f);
			g.textAlign(CENTER, CENTER);
			g.fill(0);
			g.text(label, x, y - 25);
			g.popStyle();
		}
	}

	void bg() {
		g.pushStyle();
		g.rectMode(CENTER);
		g.fill(255);
		g.stroke(30);
		g.rect(x, y, w, h);
		g.arc((float) (x - w * .49), y, h, h, HALF_PI, HALF_PI * 3, OPEN);
		g.arc((float) (x + w * .5), y, h, h, HALF_PI * 3, HALF_PI * 5, OPEN);
		float xi = (float) (x - w * .45);
		float step = (float) (((x + w * .45) - xi) / 10);
		for (int i = 0; i < (w * .9) / step + 1; i++) {
			g.fill(30);
			g.strokeWeight((float) (1.5));
			if (i % 2 == 1)
				g.strokeWeight((float) (.5));
			g.rect(xi + step * i, y, 2, 10);
		}
		g.strokeWeight(3);
		g.line(xi, y, xi + step * 10, y);
		g.popStyle();
	}

	void slider() {
		g.pushStyle();
		float xs = (float) (x - w * .45 + percent * (w * .9));
		g.rectMode(CENTER);
		g.fill(255);
		g.stroke(0);
		g.beginShape();
		g.vertex((float) (xs - 3.5), (float) (y - 7.5));
		g.vertex((float) (xs - 3.5), (float) (y + 7.5));
		g.vertex(xs, (float) (y + 10));
		g.vertex((float) (xs + 3.5), (float) (y + 7.5));
		g.vertex((float) (xs + 3.5), (float) (y - 7.5));
		g.endShape(CLOSE);
		// g.rect(xs, y, 7, 15);
		g.popStyle();
	}

	void slide() {
		float xs = (float) (x - w * .45 + percent * (w * .9));
		if (p.mousePressed && p.mouseX > x - .45 * w && p.mouseX < x + .45 * w
				&& p.mouseY > y - 7.5 && p.mouseY < y + 7.5) {
			percent = PApplet.constrain(PApplet.map((float) (p.mouseX),
					(float) (x - .45 * w), (float) (x + .45 * w), 0.0f, 1.0f),
					0.0f, 1.0f);
		}
	}

	boolean slid() {
		return (p.mousePressed && p.mouseX > x - .45 * w
				&& p.mouseX < x + .45 * w && p.mouseY > y - 7.5 && p.mouseY < y + 7.5);
	}

	public float p() {
		return (percent * (min + (max - min)));
	}

	void init(PApplet p, float x, float y, float min, float max) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.min = min;
		this.max = max;

		this.percent = .5f;
		this.w = 150;
		this.h = 20;
		f = p.createFont("Georgia", 20, true);
		g = p.g;
	}

}
