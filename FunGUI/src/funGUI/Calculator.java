package funGUI;
import processing.core.*;

public class Calculator extends Frame {
	RoundButton [][] nums = new RoundButton [3][4];
	
	public Calculator(PApplet p, float x, float y, float w, float h) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				String chars = Integer.toString(9 - ((2 - i) + j * 3));
				if (i < 3 && j < 3) {
					nums[i][j] = new RoundButton(p, x + (i - 1) * 50, y + (j - 1) * 50, 20, chars.charAt(0));
				} else {
					nums[i][j] = new RoundButton(p, x + (i - 1) * 50, y + (j - 1) * 50, 20, ' ');
				}
			}
		}
		nums[0][3] = new RoundButton(p, x - 50, y + 100, 20, '0');
		nums[1][3] = new RoundButton(p, x, y + 100, 20, '.');
		nums[2][3] = new RoundButton(p, x + 50, y + 100, 20, 'c');
		
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
