package funGUI;
import processing.core.*;

interface FunGUIObject extends PConstants {
	public static final float REGTXTSIZE = 13;
	public static final float SMLTXTSIZE = 10;
	public static final float MEDTXTSIZE = 15;
	public static final float LGTXTSIZE = 20;
	
	public float x();
	public float y();
	public float h();
	public float w();
}
