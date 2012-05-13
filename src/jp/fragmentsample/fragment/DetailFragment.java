package jp.fragmentsample.fragment;

import java.util.ArrayList;

import jp.fragmentsample.R;
import jp.fragmentsample.adapter.InfoListAdapter;
import jp.fragmentsample.adapter.ItemListAdapter;
import jp.fragmentsample.adapter.LabelListAdapter;
import jp.fragmentsample.model.DummyGenerator;
import jp.fragmentsample.model.Info;
import jp.fragmentsample.model.Item;
import jp.fragmentsample.model.Label;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class DetailFragment extends ListFragment implements TabHost.OnTabChangeListener {
	
	public static final String TAG = DetailFragment.class.getSimpleName();

	ArrayAdapter<Info> adapter0;
	ArrayAdapter<Item> adapter1;
	ArrayAdapter<Label> adapter2;
		
	private final ArrayList<String> tabs = new ArrayList<String>();
	private View headerView;
	private int headerRes;
	private String headerLabel;
	private TabHost tabHost;
	private int tabPos;
	
	public DetailFragment(Item item) {
		headerRes = item.getDrawable();
		headerLabel = item.getLabel();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Activity activity = getActivity();
		adapter0 = new InfoListAdapter(activity, DummyGenerator.getInfoList());
		adapter1 = new ItemListAdapter(activity, DummyGenerator.getItemShapeList());
		adapter2 = new LabelListAdapter(activity, DummyGenerator.getLabelList());
		
		tabPos = 0;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		setListAdapter(null);
		//if (headerView == null) {
			LayoutInflater inflater = getActivity().getLayoutInflater();
			headerView = inflater.inflate(R.layout.detail_header, null);
			ImageView image = (ImageView)headerView.findViewById(R.id.detail_header_img);
			image.setImageResource(headerRes);
			TextView text = (TextView)headerView.findViewById(R.id.detail_header_label);
			text.setText(headerLabel);
			getListView().addHeaderView(headerView);
			
			tabHost = (TabHost)headerView.findViewById(android.R.id.tabhost);
			tabHost.setup();
			tabHost.setOnTabChangedListener(this);
			
			DisplayMetrics metrics = new DisplayMetrics();
	        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
	        int tabWidth = metrics.widthPixels / 3;
	        int tabHeight = tabWidth / 3;
	        
	        final String[] tabnames = {"Info", "Related", "Tag"};
	        for (int i = 0; i < 3; i++) {
	        	TabSpec spec = tabHost.newTabSpec("tab"+i);
	        	spec.setIndicator(getTabView(tabWidth, tabHeight, tabnames[i]));
	        	
	        	spec.setContent(new DummyTabFactory(getActivity()));
				tabs.add("tab"+i);
				tabHost.addTab(spec);
	        }
		//}
		
		changeAdapter(tabPos);
	}
	
	// dummy contents class
	class DummyTabFactory implements TabHost.TabContentFactory {
		private final Context context;
		
		public DummyTabFactory(Context context) {
			this.context = context;
		}

		public View createTabContent(String tag) {
			View v = new View(context);
			v.setMinimumWidth(0);
			v.setMinimumHeight(0);
			return v;
		}
	}
	
	 private TextView getTabView(int width, int height, String title) {
    	TextView view = new TextView(getActivity());
    	view.setMinimumWidth(width);
    	view.setMinimumHeight(height);
    	view.setGravity(Gravity.CENTER);
    	view.setBackgroundResource(R.drawable.tab_indicator_holo);
    	view.setText(title);
    	return view;
    }

	public void changeAdapter(int index) {
		switch (index) {
		case 0:
			setListAdapter(adapter0);
			break;
		case 1:
			setListAdapter(adapter1);
			break;
		case 2:
			setListAdapter(adapter2);
			break;
		}
	}

	public void onTabChanged(String tabId) {
		if (tabHost != null) {
			tabPos = tabHost.getCurrentTab();
			changeAdapter(tabPos);
		}
	}
}
