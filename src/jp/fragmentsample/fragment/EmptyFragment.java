package jp.fragmentsample.fragment;

import jp.fragmentsample.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EmptyFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceBundle) {
		return inflater.inflate(R.layout.empty_fragmen, container, false);
	}
}
