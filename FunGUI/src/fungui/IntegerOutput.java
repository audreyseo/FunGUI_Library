package fungui;

public class IntegerOutput extends NumOutput {
	IncrementalSlider s;
	
	public IntegerOutput(float x, float y, float w, float h, IncrementalSlider slider) {
		super(x, y, w, h, slider);
		this.s = slider;
		
	}

	@Override
	public float val() {
		return(s.increment());
	}
}
