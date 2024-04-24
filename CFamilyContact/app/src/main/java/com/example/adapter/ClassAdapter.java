package com.example.adapter;

import android.content.Context;
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

public class ClassAdapter extends BaseAdapter {
	private Context context;
	private List<ClassRoom> itemlist;
	private LayoutInflater minflater;
	private Handler mHandler;
	private int mMode;

	public ClassAdapter(Context paramContext, List<ClassRoom> paramArrayList,
			Handler han) {

		this.context = paramContext;
		this.itemlist = paramArrayList;
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
			paramView = this.minflater.inflate(R.layout.adp_book,
					paramViewGroup, false);
			localviewHolder.title = ((TextView) paramView
					.findViewById(R.id.adp_bookname));

			paramView.setTag(localviewHolder);
		} else {
			localviewHolder = (viewHolder) paramView.getTag();
		}

		if ((this.itemlist != null) && (this.itemlist.size() > 0)) {
 
			String name =  itemlist.get(paramInt).getName() ;
			if (name != null) {
				localviewHolder.title.setText(name);

			}

		}
		return paramView;

	}

	class viewHolder {
		TextView title, content;
		ImageView icon;
		FrameLayout layout;
	}
}
