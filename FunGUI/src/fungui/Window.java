package fungui;

/**
 * A window is what a display should be, except that a display is
 * rarely used as is. The window contains information and widgets,
 * and you can choose whether the widget is centered or left-
 * aligned or whatever you wish.
 * @author audrey
 *
 */
public class Window extends Display {
	public Window(float x, float y, float w, float h) {
		super(x, y, w, h);
	}
}
