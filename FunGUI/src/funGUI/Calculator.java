package funGUI;
import processing.core.*;

public class Calculator extends Frame {
	RoundButton [][] nums = new RoundButton [4][4];
	
	public Calculator(PApplet p, float x, float y, float w, float h) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				String chars = Integer.toString(i + j * 3);
				if (Integer.getInteger(chars) <= 8) {
					nums[i][j] = new RoundButton(p, x + (i - 1) * 50, y + (j - 1) * 50, 20, chars.charAt(0));
				} else {
					nums[i][j] = new RoundButton(p, x + (i - 1) * 50, y + (j - 1) * 50, 20, ' ');
				}
			}
		}
		nums[0][3] = new RoundButton(p, x - 50, y + 100, 20, '9');
		
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
