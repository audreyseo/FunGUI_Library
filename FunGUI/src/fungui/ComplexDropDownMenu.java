package fungui;

import processing.core.PApplet;
import processing.core.PFont;
import processing.data.FloatList;

public class ComplexDropDownMenu extends DropDownMenu {
	DropDownSubMenuItem [] submenus;
	int submenuChoice = -1;
	int stagger = 0;
	int clicked;
	int oldClick = 0;
	
	public ComplexDropDownMenu(PApplet p, float ex, float why, String [] optionLabels, String [][] submenus) {
		super(p, ex, why, optionLabels);
		this.items = new DropDownMenuItem [optionLabels.length - submenus.length];
		PFont font = this.p.createFont("Helvetica", 13);
		p.textFont(font);
		FloatList textSizes = new FloatList();
		for (int i = 0; i < optionLabels.length; i++) {
			textSizes.append((float) (p.g.textWidth(optionLabels[i]) * 1.2));
		}
		for (int i = 0; i < optionLabels.length - submenus.length; i++) {
			items[i] = new DropDownMenuItem(p, ex, why, optionLabels[i], 1, textSizes.max(), i, this);
		}
		
		this.submenus = new DropDownSubMenuItem [submenus.length];
		int start = optionLabels.length - submenus.length;
		stagger = start;
		for (int i = 0; i < submenus.length; i++) {
			this.submenus[i] = new DropDownSubMenuItem(p, ex, why, optionLabels[start + i], 1, textSizes.max(), start + i, this, submenus[i]);
		}
		
		w = items[0].w;
		this.g = this.p.g;
		x = ex;
		y = why;
	}
	
	@Override
	public void draw() {
		super.draw();
		for (int i = 0; i < submenus.length; i++) {
			if (submenus[i].selectionComplete() || dropDownSelected) {
				g.pushMatrix();
				if (!dropDownSelected) {
					g.translate(0,  -1 * (stagger + i) * 18);
				}
				submenus[i].draw(dropDownSelected);
				g.popMatrix();
//				if (submenus[i].selectionComplete() && submenus[i].m.selectedOption > 0 && submenus[i].m.selectedOption != submenuChoice && dropDownSelected) {
//					dropDownSelected = false;
//				}
				mutuallyExclusive(stagger + i);
			}
		}
	}
	
	void dropDownSelected() {
		if (!dropDownPressed && clicked()) {
			dropDownSelected = !dropDownSelected;
			for (int i = 0; i < submenus.length; i++) {
				submenus[i].showingOptions = true;
			}
			clicked++;
		}
		dropDownPressed = clicked();
	}

	public void printOptions() {
		if (clicked != oldClick) {
			for (int i = 0; i < submenus.length; i++) {
				PApplet.print(i + ": " + submenus[i].showing() + " " + submenus[i].selectionComplete() + " " + clicked + "  ");
			}
			PApplet.println("");
			oldClick = clicked;
		}
	}

	@Override
	protected void mutuallyExclusive(int i) {
		if (i < stagger) {
			if (items[i].selected) {

				if (selectedOption < 0) {
					selectedOption = i;
					if (dropDownSelected) {
						dropDownSelected = false;
					}
				} else if (selectedOption != i) {
					if (selectedOption >= stagger) {
						submenus[selectedOption - stagger].deselect();
						submenus[selectedOption - stagger].deselectSubMenu();
						PApplet.println("Deselected Other Submenu Properly");
					} else {
						items[selectedOption].selected = false;
					}
					selectedOption = i;
					submenuChoice = -1;
					if (dropDownSelected) {
						dropDownSelected = false;
					}
				}
			}
		} else {
			if (submenus[i - stagger].selectionComplete()) {
				if (selectedOption < 0) {
					selectedOption = i;
					submenuChoice = submenus[i - stagger].m.selectedOption;
					if (dropDownSelected) {
						dropDownSelected = false;
						submenus[i - stagger].showingOptions = false;
					}
				} else if (selectedOption != i || (submenus[i - stagger].m.selectedOption > 0 && submenus[i - stagger].m.selectedOption != submenuChoice)) {
					
					if (selectedOption >= stagger) {
						submenus[selectedOption - stagger].deselect();
						submenus[selectedOption - stagger].deselectSubMenu();
						PApplet.println("Deselected Other Submenu Properly");
					} else {
						items[selectedOption].selected = false;
					}
					selectedOption = i;
					submenuChoice = submenus[i - stagger].m.selectedOption;
					if (dropDownSelected) {
						dropDownSelected = false;
						submenus[i - stagger].showingOptions = false;
					}
					PApplet.println("done");
				}
				clicked++;
			}
		}
	}
}
