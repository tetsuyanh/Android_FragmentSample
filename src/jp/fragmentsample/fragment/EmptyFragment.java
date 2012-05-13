package jp.fragmentsample.fragment;

import jp.fragmentsample.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EmptyFragment extends Fragment {
	
	private int color;
	
	public EmptyFragment(int color) {
		this.color = color;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceBundle) {
		View view = inflater.inflate(R.layout.empty_fragmen, container, false);
		view.setBackgroundColor(color);
		
		return view;
	}
}
