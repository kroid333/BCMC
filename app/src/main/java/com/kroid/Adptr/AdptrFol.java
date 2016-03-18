package com.kroid.Adptr;

import java.util.ArrayList;
import java.util.HashMap;

import com.kroid.bcmc.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdptrFol extends BaseAdapter {

	ArrayList<String> data;
	Context c;

	 private int mLastPosition;

	public AdptrFol(Context c1, ArrayList<String> d) {
		// TODO Auto-generated constructor stub
		data = new ArrayList<String>();
		c = c1;
		data = d;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder Holder;
		View vi = convertView;
		if (vi == null) {
			LayoutInflater layouinfla = (LayoutInflater) c
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			vi = layouinfla.inflate(R.layout.list_agecat_picmk3, null);
			Holder = new ViewHolder();
			Holder.txtMain = (TextView) vi.findViewById(R.id.txtName);
			vi.setTag(Holder);
		} 
		else 
		{
			Holder = (ViewHolder) vi.getTag();
		}
		Holder.txtMain.setText(data.get(position).toString());
		return vi;
	}
	 class ViewHolder {
		TextView txtMain;
	}

}
