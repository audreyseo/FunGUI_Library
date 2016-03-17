package fungui;
import processing.core.*;

/**
 * 
 * @author audrey
 *
 */
public class Menu extends List {
	MenuItem [] items;
	
	/**
	 * Constructor for the class Menu, a pop-up list of items to choose from
	 * @param p				PApplet, the parent sketch, usually "this'
	 * @param ex			float, the x-coordinate of the top left corner of the menu
	 * @param why			float, the y-coordinate of the top left corner of the menu
	 * @param optionLabels	String, the names for the various menu items
	 * @param t				String, the "type" of the items, ex. "food"
	 */
	public Menu(PApplet p, float ex, float why, String [] optionLabels, String t) {
		super(p, ex, why, optionLabels, t, new Display(ex, why, 400, 1000), 1);
		items = new MenuItem [optionLabels.length];
		for (int i = 0; i < optionLabels.length; i++) {
			items[i] = new MenuItem(p, ex, why, optionLabels[i], 1, 400, i, this);
		}
	}
	
	/**
	 * Constructor for the class Menu, a pop-up list of items to choose from
	 * @param p				PApplet, the parent sketch, usually "this'
	 * @param ex			float, the x-coordinate of the top left corner of the menu
	 * @param why			float, the y-coordinate of the top left corner of the menu
	 * @param optionLabels	String, the names for the various menu items
	 * @param t				String, the "type" of the items, ex. "food"
	 * @param d				Display, the display that will contain the entire list
	 * @param numColumns	int, the number of columns that this list will have
	 */
	public Menu(PApplet p, float ex, float why, String [] optionLabels, String t, Display d, int numColumns) {
		super(p, ex, why, optionLabels, t, d, numColumns);
		items = new MenuItem [optionLabels.length];
		for (int i = 0; i < optionLabels.length; i++) {
			items[i] = new MenuItem(p, ex, why, optionLabels[i], numColumns, d.w, i, this);
		}
	}
	
	@Override
	public void draw() {
		limitwidth();
		for (int i = 0; i < options.length; i++) {
			items[i].display();
			mutuallyExclusive(i);
		}
	}
}
