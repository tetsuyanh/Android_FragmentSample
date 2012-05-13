package jp.fragmentsample.model;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String label;
	private int drawable;
	private List<Info> infos;
	private List<Item> relations;
	
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
	
	public Item setLabel(String label) {
		this.label = label;
		return this;
	}
	
	public int getDrawable() {
		return drawable;
	}
	
	public Item setDrawable(int drawable) {
		this.drawable = drawable;
		return this;
	}
	
	public List<Info> getInfos() {
		return infos;
	}
	
	public Item addInfo(Info info) {
		infos.add(info);
		return this;
	}
	
	public void clearInfos() {
		infos.clear();
	}

	public List<Item> getRelations() {
		return relations;
	}
	
	public Item addRelation(Item item) {
		relations.add(item);
		return this;
	}
	
	public void clearRelations() {
		relations.clear();
	}
	
}
