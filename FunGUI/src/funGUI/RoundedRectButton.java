package funGUI;

import processing.core.*;

public class RoundedRectButton extends RectButton implements PConstants {
	float curvature = 0.0f;
	float curveRadius = 0.0f;
	float innerCurveRadius = 0.0f;
	
	/**
	 * Constructor for the RoundedRectButton class.
	 * @param p			PApplet, the parent sketch of the object (usually "this")
	 * @param nx		float, the horizontal location of the center of this button
	 * @param ny		float, the vertical location of the center of this button
	 * @param nw		float, the horizontal length of this button
	 * @param nh		float, the vertical length of this button
	 * @param ncolors	color, the colors used in this button
	 * @param ntext		String, the string value of the name of this button
	 * @param curvature	float, the percent by which to curve the button's corners in
	 */
	public RoundedRectButton(PApplet p, float nx, float ny, float nw, float nh, int [] ncolors, String ntext, float curvature) {
		super(p, nx, ny, nw, nh, ncolors, ntext);
		this.curvature = PApplet.constrain(curvature, 0.1f, 1);
		calculateRadius();
	}
	
	/**
	 * Constructor for the RoundedRectButton class. Uses a default amount of curvature.
	 * @param p			PApplet, the parent sketch of the object (usually "this")
	 * @param nx		float, the horizontal location of the center of this button
	 * @param ny		float, the vertical location of the center of this button
	 * @param nw		float, the horizontal length of this button
	 * @param nh		float, the vertical length of this button
	 * @param ncolors	color, the colors used in this button
	 * @param ntext		String, the string value of the name of this button
	 */
	public RoundedRectButton(PApplet p, float nx, float ny, float nw, float nh, int [] ncolors, String ntext) {
		super(p, nx, ny, nw, nh, ncolors, ntext);
		curvature = 0.25f;
		calculateRadius();
	}
	

	@Override
	public void backShape(float xi, float yi, float wi, float hi) {
		float wi2 = (float) (wi * .5);
		float hi2 = (float) (hi * .5);
		float partialW = (float) (wi2 - r());
		float partialH = (float) (hi2 - r());
		//PApplet.println("PartialW: " + partialW);
		float x1a = xi - wi2;
		float x1b = xi - partialW;
		
		float x2a = xi + wi2;
		float x2b = xi + partialW;
		
		float y1a = yi - hi2;
		float y1b = yi - partialH;
		
		float y2a = yi + hi2;
		float y2b = yi + partialH;
		
		g.beginShape();
		// First corner
		g.vertex(x1b, y1a);
		g.vertex(x1a, y1b);
		
		// Second corner
		g.vertex(x1a, y2b);
		g.vertex(x1b, y2a);
		// Third corner
		g.vertex(x2b, y2a);
		g.vertex(x2a, y2b);
		
		// Fourth corner
		g.vertex(x2a, y1b);
		g.vertex(x2b, y1a);
		g.endShape(CLOSE);
		
		float diameter = (float) (PApplet.dist(0, 0, r(), r()));
		float radius = diameter * .5f;
		float xa = x1a + radius;
		float xb = x2a - radius;
		float ya = y1a + radius;
		float yb = y2a - radius;
		
		
		//float theta = 0;
		float dth = HALF_PI;
		// First corner - arc
		g.arc(xa, ya, diameter, diameter, PI - dth, 3 * HALF_PI + dth, CHORD);
		
		// Second corner - arc
		g.arc(xa, yb, diameter, diameter, HALF_PI - dth, PI + dth, CHORD);
		
		// Third corner - arc
		g.arc(xb, yb, diameter, diameter, -dth, HALF_PI + dth, CHORD);
		
		// Fourth corner - arc
		g.arc(xb, ya, diameter, diameter, -HALF_PI - dth, dth, CHORD);
	}
	
	@Override
	public void innerBackShape(float xi, float yi, float wi, float hi) {
		float wi2 = (float) (wi * .5);
		float hi2 = (float) (hi * .5);
		float partialW = (float) (wi2 - ir());
		float partialH = (float) (hi2 - ir());
		//PApplet.println("partialW: " + partialW);
		float x1a = xi - wi2;
		float x1b = xi - partialW;
		
		float x2a = xi + wi2;
		float x2b = xi + partialW;
		
		float y1a = yi - hi2;
		float y1b = yi - partialH;
		
		float y2a = yi + hi2;
		float y2b = yi + partialH;
		
		g.beginShape();
		// First corner
		g.vertex(x1b, y1a);
		g.vertex(x1a, y1b);
		
		// Second corner
		g.vertex(x1a, y2b);
		g.vertex(x1b, y2a);
		// Third corner
		g.vertex(x2b, y2a);
		g.vertex(x2a, y2b);
		
		// Fourth corner
		g.vertex(x2a, y1b);
		g.vertex(x2b, y1a);
		g.endShape(CLOSE);
		
		float diameter = (float) (PApplet.dist(0, 0, ir(), ir()));
		
		float radius = diameter * .5f;
//		PApplet.println("Radius: " + r() + " Inner Radius: " + ir());
//		PApplet.println("Real radius: " + radius);
		float xa = x1a + radius;
		float xb = x2a - radius;
		float ya = y1a + radius;
		float yb = y2a - radius;
		
		
		//float theta = 0;
		float dth = HALF_PI;
		// First corner - arc
		g.arc(xa, ya, diameter, diameter, PI - dth, 3 * HALF_PI + dth, CHORD);
		
		// Second corner - arc
		g.arc(xa, yb, diameter, diameter, HALF_PI - dth, PI + dth, CHORD);
		
		// Third corner - arc
		g.arc(xb, yb, diameter, diameter, -dth, HALF_PI + dth, CHORD);
		
		// Fourth corner - arc
		g.arc(xb, ya, diameter, diameter, -HALF_PI - dth, dth, CHORD);
	}
	
	public void changeCurvature(float f) {
		this.curvature = f;
		calculateRadius();
	}
	
	private void calculateRadius() {
		float rh = rH();
		float rw = rW();
		float rih = (float) (ih() * curvature * .5);
		float riw = (float) (iw() * curvature * .5);
		if (rh < rw) {
			if (rw < h * .5) {
				curveRadius = rw;
			} else {
				curveRadius = (float) (h * .4);
			}
		} else {
			if (rh < w * .5) {
				curveRadius = rh;
			} else {
				curveRadius = (float) (w * .4);
			}
		}
		
		float widthRatio = (w / iw());
		float heightRatio = (h / ih());
		
		if (rih < riw) {
			if (riw < ih() * .5) {
				innerCurveRadius = riw;
			} else {
				innerCurveRadius = (float) (h() * .4 * heightRatio);
			}
		} else {
			if (rih < iw() * .5) {
				innerCurveRadius = rih;
			} else {
				innerCurveRadius = (float) (w() * .4 * widthRatio);
			}
		}
	}
	
	private float r() {
		return(curveRadius);
	}
	
	private float ir() {
		return(innerCurveRadius);
	}
	
	/**
	 * Calculates the amount of the height that is cut out by curvature, aka the radius of the height curvature
	 * @return
	 */
	private float rH() {
		return((float) (curvature * h * .5));
	}
	
	private float rW() {
		return((float) (curvature * w * .5));
	}
	
//	private float complement() {
//		return(1 - curvature);
//	}
	
	public float avg(float one, float two) {
		return((float) ((one + two) / 2));
	}
}