package funGUI;
import processing.core.*;


public class Matrix {
	public static enum ClassType {
		GUIFRAME,
		SLIDER,
		TEXTDISPLAY,
		TOGGLER;
	}
	public float colw, rowh;
	public float x, y;
	public int rows, cols;
	public Frame [][] matrix;
	
	public Matrix(float w, float h, int row, int col) {
		init(w, h, row, col);
	}
	
	public Matrix(float x, float y, float w, float h, int row, int col)  {
		init(w, h, row, col);
		this.x = x;
		this.y = y;
	}
	
	public void assign(int xi, int yi, ClassType t) {
		switch(t) {
		case GUIFRAME:
			break;
		case SLIDER:
			break;
		case TEXTDISPLAY:
			break;
		case TOGGLER:
			break;
		}
	}
	
	public void init(float w, float h, int row, int col) {
		this.rows = row;
		this.cols = cols;
		this.colw = w / cols;
		this.rowh = h / rows;
		matrix = new Frame [cols][rows];
	}
}
