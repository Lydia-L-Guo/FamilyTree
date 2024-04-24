package com.example.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;

import java.util.List;

import com.example.cfamilycontact.R;
import com.example.data.ClassRoom;
import com.example.data.FamilyData;

public class TitleAdapter extends BaseAdapter {
	private Context context;
	private List<Integer> itemlist;
	private LayoutInflater minflater;
	private Handler mHandler;
	private int mInext;

	public TitleAdapter(Context paramContext, List<Integer> itemlist,
			Handler han) {

		this.context = paramContext;
		this.itemlist = itemlist;
		this.mHandler = han;
		this.minflater = LayoutInflater.from(paramContext);

	}

	public int getCount() {

		return itemlist.size();
	}

	public Object getItem(int paramInt) {
		return this.itemlist.get(paramInt);
	}

	public long getItemId(int paramInt) {
		return paramInt;
	}

	public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
		viewHolder localviewHolder = null;
		if (localviewHolder == null) {
			localviewHolder = new viewHolder();
			paramView = this.minflater.inflate(R.layout.adp_title,
					paramViewGroup, false);
			localviewHolder.content = ((TextView) paramView
					.findViewById(R.id.adp_familyname));
			
			localviewHolder.icon = ((ImageView) paramView
					.findViewById(R.id.adp_familyimg));

			paramView.setTag(localviewHolder);
		} else {
			localviewHolder = (viewHolder) paramView.getTag();
		}

		if ((this.itemlist != null) && (this.itemlist.size() > 0)) {

		 
					 
					 localviewHolder.content.setText((paramInt+1)+"世(辈)");
			 
		}
		return paramView;

	}

	class viewHolder {
		TextView   content;
		ImageView icon;
		FrameLayout layout;
	}
}
