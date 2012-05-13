package jp.fragmentsample.fragment;

import jp.fragmentsample.R;
import jp.fragmentsample.model.DummyGenerator;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class ButtonSwitchFragment extends Fragment {
	
	public static final String TAG = ButtonSwitchFragment.class.getSimpleName();

	private ItemListFragment fragLeft;
	private ItemListFragment fragCenter;
	private EmptyFragment fragRight;
	
	private View view;
	private int indexFragment;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		fragLeft = new ItemListFragment(DummyGenerator.getItemNumberList(), true);
		fragCenter = new ItemListFragment(DummyGenerator.getItemAlphabetList(), true);
		fragRight = new EmptyFragment(Color.WHITE);
		
		view = null;
		indexFragment = 0;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		view = inflater.inflate(R.layout.buttonswitch_fragment, container, false);
		
		RadioGroup group = (RadioGroup)view.findViewById(R.id.rb_group);
		group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				//changeFragment(checkedId);
				switch (group.getCheckedRadioButtonId()) {
				case R.id.rb_left: changeFragment(0); break;
				case R.id.rb_center: changeFragment(1); break;
				case R.id.rb_right: changeFragment(2); break;
				}
			}
		});
		
		changeFragment(indexFragment);
		
		return view;
	}
	
	public void changeFragment(int index) {
		FragmentManager fragMgr = getFragmentManager();
		FragmentTransaction fragTrs = fragMgr.beginTransaction();
		
		indexFragment = index;
		switch (indexFragment) {
		case 0:
			fragTrs.replace(R.id.lyt_main_fragment_container, new ItemListFragment(DummyGenerator.getItemNumberList(), true));
			break;
		case 1:
			fragTrs.replace(R.id.lyt_main_fragment_container, new ItemListFragment(DummyGenerator.getItemAlphabetList(), true));
			break;
		case 2:
			fragTrs.replace(R.id.lyt_main_fragment_container, new EmptyFragment(Color.WHITE));
			break;
		/*case 0:
			fragTrs.replace(R.id.lyt_main_fragment_container, fragLeft);
			break;
		case 1:
			fragTrs.replace(R.id.lyt_main_fragment_container, fragCenter);
			break;
		case 2:
			fragTrs.replace(R.id.lyt_main_fragment_container, fragRight);
			break;*/
		}
		fragTrs.commit();
	}

}
