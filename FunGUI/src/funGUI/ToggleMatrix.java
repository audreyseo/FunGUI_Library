package funGUI;
import processing.core.*;
import funGUI.ToggleButton;

public class ToggleMatrix {
	private ToggleButton [][] toggles;
	private float longest = 0;
	PApplet p;
	
	public ToggleMatrix(PApplet p, int x, int y, float width, float height) {
		toggles = new ToggleButton [x][y];
		this.p = p;
		float w = width / (float) (x);
		float h = height / (float) (y);
		for (int i = 0; i < toggles.length; i++) {
			for (int j = 0; j < toggles[i].length; j++) {
				toggles[i][j] = new ToggleButton(p, i * w, j * h);
			}
		}
	}
	
	public void name(int x, int y, String name) {
		x = PApplet.constrain(x, 0, toggles.length);
		y = PApplet.constrain(y, 0, toggles[0].length);
		toggles[x][y].name(name);
	}
	
	public void draw() {
		for (int i = 0; i < toggles.length; i++) {
			for (int j = 0; j < toggles[i].length; j++) {
				toggles[i][j].draw();
			}
		}
	}
}
