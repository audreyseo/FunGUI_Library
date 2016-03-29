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
