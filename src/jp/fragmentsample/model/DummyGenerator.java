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

	public static ArrayList<Label> getIndexList() {
		ArrayList<Label> list = new ArrayList<Label>();
		list.add(new Label().setLabel("動物").setIndex(true));
		list.add(new Label().setLabel("犬"));
		list.add(new Label().setLabel("猫"));
		list.add(new Label().setLabel("虎"));
		list.add(new Label().setLabel("牛"));
		list.add(new Label().setLabel("象"));
		list.add(new Label().setLabel("ネズミ"));
		list.add(new Label().setLabel("食べ物").setIndex(true));
		list.add(new Label().setLabel("カレー"));
		list.add(new Label().setLabel("ラーメン"));
		list.add(new Label().setLabel("ハンバーガー"));
		list.add(new Label().setLabel("寿司"));
		list.add(new Label().setLabel("パスタ"));
		list.add(new Label().setLabel("都市").setIndex(true));
		list.add(new Label().setLabel("川崎市"));
		list.add(new Label().setLabel("防府市"));
		list.add(new Label().setLabel("渋谷区"));
		list.add(new Label().setLabel("自由が丘"));
		list.add(new Label().setLabel("TV program").setIndex(true));
		list.add(new Label().setLabel("glee"));
		list.add(new Label().setLabel("新ビバリーヒルズ青春白書"));
		list.add(new Label().setLabel("笑点"));
		list.add(new Label().setLabel("ガキの使いやあらへんで"));
		list.add(new Label().setLabel("世界のはてまでいってＱ"));
		
		return list;
	}
}
