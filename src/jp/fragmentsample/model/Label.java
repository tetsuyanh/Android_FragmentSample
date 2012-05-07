package jp.fragmentsample.model;

//import android.graphics.drawable.Drawable;

public class Label {

	private String label;
	private boolean index = false;
	
	public String getLabel() {
		return label;
	}
	
	public Label setLabel(String label) {
		this.label = label;
		return this;
	}
	
	public boolean isIndex() {
		return index;
	}
	
	public Label setIndex(boolean flag) {
		this.index = flag;
		return this;
	}
}
