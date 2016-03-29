package funGUI;
import processing.core.*;

public class Calculator extends Frame {
	
	public Calculator(PApplet p, float x, float y, float w, float h) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	
	
	@Override
	public String returnName() {
		return("Calculator");
	}
}
