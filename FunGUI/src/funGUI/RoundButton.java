package funGUI;
import processing.core.*;

public class RoundButton extends Button {
	public float r;
	
	public RoundButton(PApplet p, float x, float y, float r){
		this.x = x;
		this.y = y;
		this.p = p;
		this.g = p.g;
		this.r = r;
	}
	
	@Override
	public void display() {
		g.pushStyle();
		g.noStroke();
		g.fill(220);
		g.ellipse(x, y, r * 2, r * 2);
		if (p.mousePressed) {
			g.fill(240, 240, 240);
		} else {
			g.fill(255, 255, 255);
		}
		g.ellipse(x, y, r * 1.8f, r * 1.8f);
		g.popStyle();
	}
	
	@Override
	public float w() {
		return(r());
	}
	
	@Override
	public float h() {
		return(r());
	}
	
	public float r() {
		return(r);
	}
	
	@Override
	public String returnName() {
		return("RoundButton");
	}
}
