package jp.fragmentsample.activity;

import java.util.ArrayList;

import jp.fragmentsample.R;
import jp.fragmentsample.fragment.ButtonSwitchFragment;
import jp.fragmentsample.fragment.EmptyFragment;
import jp.fragmentsample.fragment.LabelListFragment;
import jp.fragmentsample.model.DummyGenerator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity {
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        
        FragmentManager manager = getFragmentManager();
        
        // tabhost
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();
        
        // viewpager
        final ViewPager pager = (ViewPager)findViewById(R.id.pager);
              
        final MyAdapter1 adapter = new MyAdapter1(manager, this, tabHost, pager);
        //pager.setAdapter(adapter);
        
        // tab size from screen size
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int tabWidth = metrics.widthPixels / 3;
        int tabHeight = metrics.widthPixels / 7;
        
        for (int i = 0; i < 3; i++) {
        	TabSpec spec = tabHost.newTabSpec("tab"+i);
        	spec.setIndicator(getTabView(tabWidth, tabHeight, "TAB"+i));
        	adapter.addTab(spec, "tab"+i);
        }
        
   }
    
    private TextView getTabView(int width, int height, String title) {
    	TextView view = new TextView(this);
    	view.setMinimumWidth(width);
    	view.setMinimumHeight(height);
    	view.setGravity(Gravity.CENTER);
    	view.setBackgroundResource(R.drawable.tab_indicator_holo);
    	view.setText(title);
    	return view;
    }
    
    private class MyAdapter1 extends FragmentPagerAdapter
    	implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

    	private final Context context;
    	private final TabHost tabHost;
    	private final ViewPager pager;
    	private final ArrayList<String> tabs = new ArrayList<String>();
    	
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
    	
		public MyAdapter1(FragmentManager fm, Context context, TabHost tabHost, ViewPager pager) {
			super(fm);
			this.context = context;
			this.tabHost = tabHost;
			this.pager = pager;
			this.tabHost.setOnTabChangedListener(this);
			this.pager.setAdapter(this);
			this.pager.setOnPageChangeListener(this);
		}
		
		public void addTab(TabHost.TabSpec tabSpec, String content) {
			tabSpec.setContent(new DummyTabFactory(this.context));
			tabs.add(content);
			tabHost.addTab(tabSpec);
			notifyDataSetChanged();
		}

		@Override
		public Fragment getItem(int position) {
			if (position == 0) return new ButtonSwitchFragment();
			else if (position == 1) return new LabelListFragment(DummyGenerator.getLabelList());
			else return new EmptyFragment(Color.RED);
		}

		@Override
		public int getCount() {
			return 3;
		}

		public void onPageScrollStateChanged(int state) {
			;
		}

		public void onPageScrolled(int position, float positionOffset, int positionOggsetPixesl) {
			;
		}

		public void onPageSelected(int position) {
			TabWidget widget = tabHost.getTabWidget();
			
			int oldFocus = widget.getDescendantFocusability();
			widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
			
			tabHost.setCurrentTab(position);
			
			widget.setDescendantFocusability(oldFocus);
		}

		public void onTabChanged(String tabId) {
			int position = tabHost.getCurrentTab();
			
			pager.setCurrentItem(position);
		}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main_menu, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	return super.onOptionsItemSelected(item);
    }
}