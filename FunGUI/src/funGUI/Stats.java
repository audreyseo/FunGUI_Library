package funGUI;
import processing.data.*;
interface Stats {
	// Basic functions - mean, median, mode, standard deviation, and variance
	public float mean(FloatList f);
	public float median(FloatList f);
	public float moad(FloatList f);
	public float stdDev(FloatList f);
	public float variance(FloatList f);
	
	// Quartiles
	public float q0(FloatList f);
	public float q1(FloatList f);
	public float q2(FloatList f);
	public float q3(FloatList f);
	public float q4(FloatList f);
	public float iqr(FloatList f);
	public boolean outlier(Float f);
	public float outliersLimit(FloatList f);
	
	// Weird pieces of data, if no outliers throws NullPointerException
	public FloatList outliers(FloatList f) throws NullPointerException;
}
