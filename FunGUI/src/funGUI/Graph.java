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
	
	void drawBox() {
		//outliers = outs(outs);
	    //wra = wratio;
	    //hra = hratio;
	    if (range() > 0) {
	      float increment = range() / 20;
	      r = radius;
	      for (int i = 0; i < 21; i++) {
	        g.stroke(0);
	        int s = 1;
	        if ((i) % (4) == 0) {
	          g.fill(0);
	          String time = nfc(((i * increment) + lowest()) * .001, 2);
	          g.textAlign(CENTER, CENTER);
	          g.textFont(font, REGTXTSIZE);
	          if (remap((i * increment) + lowest(), x, r) > x + r - textWidth(time)) {
	            g.textAlign(RIGHT, CENTER);
	          } else if (i == 0)
	            g.textAlign(LEFT, CENTER);
	          text(time, remap((i * increment) + lowest(), x, r), y + 15*hratio);
	          s = 2;
	        }
	        g.strokeWeight(s);
	        g.line(remap((i * increment) + lowest(), x, r), y + 8*hratio, remap((i * increment) + lowest(), x, r), y + 6*hratio);
	      }
	    }
	}
	
	public float range() {
		float range = 0;
		switch(dimension) {
		case DATA_1D:
			range = dataX.max() - dataX.min();
			break;
		case DATA_2D:
			range = dataX.max() - dataX.min();
			break;
		case DATA_3D:
			drawAlternativeGraph();
			break;
		default:
			break;
		}
		return(range);
	}
	
	void drawGraph() {
		switch(dimension) {
		case DATA_1D:
			draw1DGraph();
			break;
		case DATA_2D:
			drawXYGraph();
			break;
		case DATA_3D:
			drawAlternativeGraph();
			break;
		default:
			break;
		}
	}
	
	void draw1DGraph() {
		
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
				// Because the dimensionality of the graph and that of the plot must match
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
