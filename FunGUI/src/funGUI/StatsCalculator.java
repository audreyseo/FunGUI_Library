package funGUI;
import processing.data.*;

class StatsCalculator implements Stats {
	public static enum DataType {
		FLOAT,
		INT;
	}
	FloatList floats;
	IntList ints;
	DataType t;

	public StatsCalculator(DataType t) {
		this.t = t;
		switch(t) {
		case FLOAT:
			floats = new FloatList();
			break;
		case INT:
			ints = new IntList();
			break;
		default:
			break;
		}
	}
	
	public void add(int i) {
		ints.append(i);
	}
	
	public void add(float f) {
		floats.append(f);
	}

	@Override
	public float mean() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float median() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float moad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float stdDev() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float variance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float q0() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float q1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float q2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float q3() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float q4() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float iqr() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean outlier(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float outliersLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FloatList outliers() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
