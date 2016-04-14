package funGUI;
import java.util.ArrayList;

import processing.core.*;

/**
 * Row is solely for the purpose of organizing a matrix.
 * @author audreyseo
 *
 */
class Row {
	ArrayList<Frame> objects = new ArrayList<Frame>();
	PApplet p;
	
	/**
	 * The constructor of the class.
	 * @param p		PApplet, the parent of the sketch (usually "this")
	 */
	public Row(PApplet p) {
		this.p = p;
	}
	
	public void addChoiceList() {
		
	}
	
	public void addDropDownMenu(float ex, float why, String [] optionLabels) {
		objects.add(new DropDownMenu(p, ex, why, optionLabels));
	}
	
	public void addGraph() {
		
	}
	
	public void addLabel() {
		
	}
	
	public void addObjectLabel() {
		
	}
	
	public void addList() {
		
	}
	
	public void addOptionList() {
		
	}
	
	public void addMenu() {
		
	}
	
	public void addMessage() {
		
	}
	
	public void addNumOutput() {
		
	}
	
	public void addPhotoButton() {
		
	}
	
	public void addRectButton() {
		
	}
	
	public void addScrollMenu() {
		
	}
	
	public void addSlider() {
		
	}
	
	public void addRow() {
		
	}
	
	public void addSliderOutput() {
		
	}
	
	public void addTextBox() {
		
	}
	
	public void addTextDisplay() {
		
	}
	
	public void addTextStrip() {
		
	}
	
	public void addToggleButton() {
		
	}
}
