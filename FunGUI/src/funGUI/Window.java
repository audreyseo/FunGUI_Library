package funGUI;

/**
 * A window is what a display should be, except that a display is
 * rarely used as is. The window contains information and widgets,
 * and you can choose whether the widget is centered or left-
 * aligned or whatever you wish.
 * @author audrey
 *
 */
public class Window extends Display {
	float horizontalMargin = 2;
	float verticalMargin = 2;
	
	
	/**
	 * Constructor for the Window class.
	 * @param x						float, x-coordinate of center of window
	 * @param y						float, y-coordinate of center of window
	 * @param w						float, width of the window
	 * @param h						float, height of the window
	 * @param horizontalMargin		float, basically the amount of area to keep clear in the x-direction along the edges
	 * @param verticalMargin		float, the amount of area to keep clear in the y-direction along the edges
	 */
	public Window(float x, float y, float w, float h, float horizontalMargin, float verticalMargin) {
		super(x, y, w, h);
		this.horizontalMargin = horizontalMargin;
		this.verticalMargin = verticalMargin;
	}
	
	public Window(float x, float y, float w, float h) {
		super(x, y, w, h);
	}
	
	float innerWidth() {
		return(w - 2 * horizontalMargin);
	}
	
	float innerHeight() {
		return(h - 2 * verticalMargin);
	}
}
