package jp.fragmentsample.adapter;

import java.util.ArrayList;

import jp.fragmentsample.R;
import jp.fragmentsample.model.Label;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LabelListAdapter extends ArrayAdapter<Label> {
	private LayoutInflater inflater;
	private Activity activity;
	
	public LabelListAdapter(Activity activity, ArrayList<Label> listIndex) {
		super(activity, R.layout.label_row, listIndex);
		this.inflater = activity.getLayoutInflater();
		this.activity = activity;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewWrapper wrapper = null;

		if (view == null) {
			view = activity.getLayoutInflater().inflate(R.layout.label_row, null);
			wrapper = new ViewWrapper(view);
			view.setTag(wrapper);
		} else {
			wrapper = (ViewWrapper)view.getTag();
		}
		
		Label index = getItem(position);

		wrapper.setText(index.getLabel(), isEnabled(position));
		
		return view;
	}
	
	@Override
	public boolean isEnabled(int position) {
		Label item = getItem(position);
		return item.isIndex();
	}
	
	class ViewWrapper {
		private View view;
		private TextView indexText;
		private TextView labelText;
		
		ViewWrapper(View view){
			this.view = view;
			this.indexText = (TextView)view.findViewById(R.id.label_row_txt_index);
			this.labelText = (TextView)view.findViewById(R.id.label_row_txt_label);
		}
		
		public void setText(String text, boolean index) {
			if (index) {
				view.setBackgroundColor(Color.RED);
				labelText.setVisibility(View.GONE);
				indexText.setVisibility(View.VISIBLE);
				indexText.setText(text);
				
			} else {
				view.setBackgroundColor(Color.WHITE);
				indexText.setVisibility(View.GONE);
				labelText.setVisibility(View.VISIBLE);
				labelText.setText(text);
			}
		}
	}
}
