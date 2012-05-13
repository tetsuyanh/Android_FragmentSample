package jp.fragmentsample.fragment;

import java.util.ArrayList;

import jp.fragmentsample.R;
import jp.fragmentsample.activity.DetailActivity;
import jp.fragmentsample.adapter.ItemListAdapter;
import jp.fragmentsample.model.Item;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemListFragment extends ListFragment {
	
	private ArrayList<Item> listOrg;
	private ArrayList<Item> list;
	private ItemListAdapter adapter;
	private View headerView;
	private int headerRes;
	private String headerTxt;
	
	ItemListFragment(ArrayList<Item> list, boolean useHeader) {
		this.list = list;
		Log.i(ItemListFragment.class.getSimpleName(), "new()");
		
		if (useHeader) {
			listOrg = (ArrayList<Item>)this.list.clone();
			headerRes = this.list.get(0).getDrawable();
			headerTxt = this.list.get(0).getLabel();
			this.list.remove(0);
		} else {
			headerRes = 0;
		}
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		setListAdapter(null);
		
		if (adapter == null) {
			if (headerRes != 0) {
				LayoutInflater inflater = getActivity().getLayoutInflater();
				headerView = inflater.inflate(R.layout.item_header, null);
				ImageView image = (ImageView)headerView.findViewById(R.id.item_header_img);
				image.setImageResource(headerRes);
				image.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(getActivity(), DetailActivity.class );
						intent.putExtra(DetailActivity.KEY_LIST, listOrg);
						intent.putExtra(DetailActivity.KEY_POSITION, 0);
						getActivity().startActivity(intent);
					}
				});
				TextView text = (TextView)headerView.findViewById(R.id.item_header_txt);
				text.setText(headerTxt);
			} else {
				headerView = null;
			}
			
			adapter = new ItemListAdapter(getActivity(), list);
		}
		
		if (headerView != null) {
			//getListView().setFadingEdgeLength(10);
			//getListView().setCacheColorHint(0);
			getListView().addHeaderView(headerView);
			getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {	
					Intent intent = new Intent(getActivity(), DetailActivity.class );
					intent.putExtra(DetailActivity.KEY_LIST, listOrg);
					intent.putExtra(DetailActivity.KEY_POSITION, position);
					getActivity().startActivity(intent);
				}
			});
		}
		setListAdapter(adapter);		
	}
}
