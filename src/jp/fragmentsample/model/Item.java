package jp.fragmentsample.model;

//import android.graphics.drawable.Drawable;

public class Item {

	private String label;
	private String text;
	private int drawable;
	private boolean index = false;
	
	public String getLabel() {
		return label;
	}
	
	public Item setLabel(String label) {
		this.label = label;
		return this;
	}
	
	public String getText() {
		return text;
	}
	
	public Item setText(String text) {
		this.text = text;
		return this;
	}
	
	public int getDrawable() {
		return drawable;
	}
	
	public Item setDrawable(int drawable) {
		this.drawable = drawable;
		return this;
	}
	
	public boolean isIndex() {
		return index;
	}
	
	public Item setIndex(boolean flag) {
		this.index = flag;
		return this;
	}
}
