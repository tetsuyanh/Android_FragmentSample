package jp.fragmentsample.model;

import java.io.Serializable;

public class Info implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String label;
	private String text;
	
	// clone
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public String getLabel() {
		return label;
	}
	
	public Info setLabel(String label) {
		this.label = label;
		return this;
	}
	
	public String getText() {
		return text;
	}
	
	public Info setText(String text) {
		this.text = text;
		return this;
	}

}
