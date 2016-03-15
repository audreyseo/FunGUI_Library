package fungui;
import processing.core.*;

public class ChoiceList extends OptionList {
	
	public ChoiceList(PApplet p, float ex, float why, int numOptions, String [] optionLabels, String t, Display d, int numColumns) {
		super(p, ex, why, numOptions, optionLabels, t, d, numColumns);
	}
	
	
	@Override
	protected void init(float ex, float why, String [] optionLabels, Display d, int numColumns) {
		for (int i = 0; i < optionLabels.length; i++) {
			options[i] = new Choice(p, ex, why + i * 20, optionLabels[i], d, numColumns);
		}
	}
	
	@Override
	protected void mutuallyExclusive(int i) {
		// Hi there, obsolete code...
	}
	
	
}
