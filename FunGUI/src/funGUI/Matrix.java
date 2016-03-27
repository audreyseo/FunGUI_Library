package funGUI;

import processing.core.*;

public class Matrix {
	public static enum ClassType {
		GUIFRAME, SLIDER, TEXTDISPLAY, TOGGLER;
	}

	public float colw, rowh;
	public float x, y;
	public int rows, cols;
	public Frame[][] matrix;
	private PApplet p;

	public Matrix(PApplet p, float w, float h, int row, int col) {
		init(w, h, row, col);
		this.p = p;
	}

	public Matrix(PApplet p, float x, float y, float w, float h, int row, int col) {
		init(w, h, row, col);
		this.x = x;
		this.y = y;
		this.p = p;
	}

	public void assign(int xi, int yi, ClassType t) {
		switch (t) {
		case GUIFRAME:
			break;
		case SLIDER:
			break;
		case TEXTDISPLAY:
			break;
		case TOGGLER:
			matrix[xi][yi] = new ToggleButton(p, x + xi * colw, y + yi * rowh, "Hi");
			break;
		}
	}
	
	public void draw() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != null) {
					PApplet.println("tried: (" + i + ", " + j + ")");
					matrix[i][j].draw();
					PApplet.println("finished");
				}
			}
		}
	}

	public void init(float w, float h, int row, int col) {
		this.rows = row;
		this.cols = col;
		this.colw = w / cols;
		this.rowh = h / rows;
		matrix = new Frame[cols][rows];
	}
}
