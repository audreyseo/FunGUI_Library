package funGUI;

import processing.core.PApplet;

public class List {
	ListItem [] options;
	int selectedOption = -1;
	String selectedLabel = "";
	String type;
	public PApplet p;
	
	public List(PApplet p, float ex, float why, String [] optionLabels, String t, Display d, int numColumns) {
		this.p = p;
		options = new ListItem [optionLabels.length];
		type = t;
		init(ex, why, optionLabels, d, numColumns);
	}
	
	public List(PApplet p, float ex, float why, int numOptions, String [] optionLabels, String t, Display d, int numColumns) {
		this.p = p;
		options = new ListItem [numOptions];
		type = t;
		init(ex, why, optionLabels, d, numColumns);
	}
	
	protected void init(float ex, float why, String [] optionLabels, Display d, int numColumns) {
		for (int i = 0; i < optionLabels.length; i++) {
			options[i] = new ListItem(p, ex, why + i * 20, optionLabels[i], d, numColumns);
		}
	}

	public void draw() {
		limitwidth();
		for (int i = 0; i < options.length; i++) {
			options[i].display();
			mutuallyExclusive(i);
		}
	}
	
	protected void mutuallyExclusive(int i) {

	}

	void limitwidth() {

	}

	boolean greaterThanZero(int i) {
		return(i > 0);
	}

	String str() {
		return(selectedLabel + type);
	}
}
