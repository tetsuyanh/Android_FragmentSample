package jp.fragmentsample.model;

import java.util.ArrayList;

import jp.fragmentsample.R;
import jp.fragmentsample.model.Label;

public class DummyGenerator {
	
	public static ArrayList<Item> getItemNumberList() {
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item().setLabel("イメージ1に関するタイトル").setDrawable(R.drawable.image_1));
		list.add(new Item().setLabel("イメージ2に関するタイトル").setDrawable(R.drawable.image_2));
		list.add(new Item().setLabel("イメージ3に関するタイトル").setDrawable(R.drawable.image_3));
		list.add(new Item().setLabel("イメージ4に関するタイトル").setDrawable(R.drawable.image_4));
		list.add(new Item().setLabel("イメージ5に関するタイトル").setDrawable(R.drawable.image_5));
		list.add(new Item().setLabel("イメージ6に関するタイトル").setDrawable(R.drawable.image_6));
		list.add(new Item().setLabel("イメージ7に関するタイトル").setDrawable(R.drawable.image_7));
		list.add(new Item().setLabel("イメージ8に関するタイトル").setDrawable(R.drawable.image_8));
		return list;
	}
	
	public static ArrayList<Item> getItemAlphabetList() {
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item().setLabel("イメージAに関するタイトル").setDrawable(R.drawable.image_a));
		list.add(new Item().setLabel("イメージBに関するタイトル").setDrawable(R.drawable.image_b));
		list.add(new Item().setLabel("イメージCに関するタイトル").setDrawable(R.drawable.image_c));
		list.add(new Item().setLabel("イメージDに関するタイトル").setDrawable(R.drawable.image_d));
		list.add(new Item().setLabel("イメージEに関するタイトル").setDrawable(R.drawable.image_e));
		list.add(new Item().setLabel("イメージFに関するタイトル").setDrawable(R.drawable.image_f));
		list.add(new Item().setLabel("イメージGに関するタイトル").setDrawable(R.drawable.image_g));
		list.add(new Item().setLabel("イメージHに関するタイトル").setDrawable(R.drawable.image_h));
		return list;
	}
	
	public static ArrayList<Item> getItemShapeList() {
		ArrayList<Item> list = new ArrayList<Item>();
		list = new ArrayList<Item>();
		list.add(new Item().setDrawable(R.drawable.image_tri).setLabel("label of triangle"));
		list.add(new Item().setDrawable(R.drawable.image_triinv).setLabel("label of triangle_inv"));
		list.add(new Item().setDrawable(R.drawable.image_circle).setLabel("label of circle"));
		list.add(new Item().setDrawable(R.drawable.image_quad).setLabel("label of quad"));
		list.add(new Item().setDrawable(R.drawable.image_dia).setLabel("label of diamond"));
		return list;
	}
	
	public static ArrayList<Info> getInfoList() {
		ArrayList<Info> list = new ArrayList<Info>();
		list = new ArrayList<Info>();
		for (int i = 0; i < 5; i++) {
			Info info = new Info();
			info.setLabel("infomation"+i).setText("Information is hogehoge. Information is hogehoge. Information is hogehoge. Information is hogehoge. Information is hogehoge. Information is hogehoge.");
			list.add(info);
		}
		return list;
	}

	public static ArrayList<Label> getLabelList() {
		ArrayList<Label> list = new ArrayList<Label>();
		list.add(new Label().setLabel("place").setIndex(true));
		list.add(new Label().setLabel("home"));
		list.add(new Label().setLabel("library"));
		list.add(new Label().setLabel("station"));
		list.add(new Label().setLabel("company"));
		list.add(new Label().setLabel("road"));
		list.add(new Label().setLabel("hospital"));
		list.add(new Label().setLabel("food").setIndex(true));
		list.add(new Label().setLabel("curry"));
		list.add(new Label().setLabel("nooodle"));
		list.add(new Label().setLabel("sushi"));
		list.add(new Label().setLabel("rice"));
		list.add(new Label().setLabel("city").setIndex(true));
		list.add(new Label().setLabel("kawasaki"));
		list.add(new Label().setLabel("shibuya"));
		list.add(new Label().setLabel("hofu"));
		list.add(new Label().setLabel("jiyugaoka"));
		list.add(new Label().setLabel("country").setIndex(true));
		list.add(new Label().setLabel("japan"));
		list.add(new Label().setLabel("usa"));
		list.add(new Label().setLabel("china"));
		list.add(new Label().setLabel("korea"));
		list.add(new Label().setLabel("italy"));
		
		return list;
	}
}
