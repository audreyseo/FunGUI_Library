package funGUI;
import processing.core.*;

public class Calculator extends Frame {
	RoundButton [][] nums = new RoundButton [3][3];
	
	public Calculator(PApplet p, float x, float y, float w, float h) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				String chars = Integer.toString(i * 3 + j);
				nums[i][j] = new RoundButton(p, x + (i - 1) * 50, y + (i - 1) * 50, 20, chars.charAt(0));
			}
		}
	}
	
	@Override
	public void draw() {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				nums[i][j].draw();
			}
		}
	}
	
	
	@Override
	public String returnName() {
		return("Calculator");
	}
}
