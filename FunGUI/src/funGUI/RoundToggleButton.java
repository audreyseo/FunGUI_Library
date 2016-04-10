package funGUI;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class RoundToggleButton extends RoundButton {
	boolean on = false;
	boolean click = false;
	
	public RoundToggleButton(PApplet p, float x, float y, float r) {
		super(p, x, y, r);
		p.registerMethod("mouseEvent", this);
	}
	
	public void mouseEvent(MouseEvent me) {
		if (me.getAction() == MouseEvent.PRESS) {
			toggle();
		}
	}
	
	void toggle() {
		if (clicked() && !click) {
			on = !on;
		}
		click = clicked();
	}

}
