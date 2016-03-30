package funGUI;
import processing.core.*;
import processing.data.*;
import java.util.ArrayList;

public class Graph extends Window {
	FloatList dataX = new FloatList();
	FloatList dataY = new FloatList();
	ArrayList<FloatList> data = new ArrayList<FloatList>();
	DataDimension dimension;
	GraphType type = null;
	
	public Graph(PApplet p, float x, float y, float w, float h, DataDimension dimension, GraphType type) {
		super(p, x, y, w, h);
		this.dimension = dimension;
		this.type = type;
		assignType();
	}
	
	
	public Graph(PApplet p, float x, float y, float w, float h, DataDimension dimension) {
		super(p, x, y, w, h);
		this.dimension = dimension;
		assignType();
	}
	
	public Graph(PApplet p, float x, float y, float w, float h) {
		super(p, x, y, w, h);
		this.dimension = DataDimension.DATA_1D;
		assignType();
	}
	
	void addDataX(float f) {
		dataX.append(f);
	}
	
	void addDataX(float [] f) {
		for (int i = dataX.size(); i < f.length; i++) {
			dataX.append(f[i]);
		}
	}
	
	void addDataX(FloatList f) {
		for (int i = dataX.size(); i < f.size(); i++) {
			dataX.append(f.get(i));
		}
	}
	
	void addDataY(float f) {
		dataY.append(f);
	}
	
	void addDataY(float [] f) {
		for (int i = dataY.size(); i < f.length; i++) {
			dataY.append(f[i]);
		}
	}
	
	void addDataY(FloatList f) {
		for (int i = dataY.size(); i < f.size(); i++) {
			dataY.append(f.get(i));
		}
	}
	
	void addData(ArrayList<FloatList> f) {
		data.clear();
		for (int i = 0; i < f.size(); i++) {
			data.add(new FloatList());
			for (int j = 0; j < f.get(i).size(); j++) {
				data.get(i).append(f.get(i).get(j));
			}
		}
	}
	
	@Override
	public void draw() {
		
	}
	
	void drawGraph() {
		switch(dimension) {
		case DATA_1D:
			break;
		case DATA_2D:
			break;
		case DATA_3D:
			break;
		default:
			break;
		}
	}
	
	void drawXYGraph() {
		
	}
	
	void drawAlternativeGraph() {
		
	}
	
	void assignType() {
		switch(dimension) {
		case DATA_1D:
			if (type == null || type.d() != 1) {
				// If type has not yet been assigned or the number of dimensions for type is not 1
				type = GraphType.DOTPLOT;
			}
			break;
		case DATA_2D:
			if (type == null || type.d() != 2) {
				// If typue has not yet been assigned or the number of dimensions for type is not 2
				type = GraphType.SCATTERPLOT;
			}
			break;
		case DATA_3D:
			// TBD
			break;
		default:
			break;
		}
	}
}
