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

public class FamilyAdapter extends BaseAdapter {
	private Context context;
	private List<FamilyData> itemlist;
	private LayoutInflater minflater;
	private Handler mHandler;
	private int mMode;
    private String mId;
	public FamilyAdapter(Context paramContext, List<FamilyData> paramArrayList,
			Handler han,String id) {

		this.context = paramContext;
		this.itemlist = paramArrayList;
		this.mHandler = han;
		mId=id;
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
			paramView = this.minflater.inflate(R.layout.adp_family,
					paramViewGroup, false);
			localviewHolder.content = ((TextView) paramView
					.findViewById(R.id.adp_familyname));
			
			localviewHolder.icon = ((ImageView) paramView
					.findViewById(R.id.adp_familyimg));
			localviewHolder.layout=(LinearLayout)paramView.findViewById(R.id.adp_layout);

			paramView.setTag(localviewHolder);
		} else {
			localviewHolder = (viewHolder) paramView.getTag();
		}

		if ((this.itemlist != null) && (this.itemlist.size() > 0)) {

			 String str=itemlist.get(paramInt).getSurname()+itemlist.get(paramInt).getGenealogy_name();
			 if (str!=null) {
				str=str.replace("null", "");
				 localviewHolder.content.setText(str+"");
			}
			
			 String gen=itemlist.get(paramInt).getGender();
			 if (gen!=null) {
				 if (gen.equals("男")) {
					 localviewHolder.icon.setBackgroundResource(R.drawable.ic_boy_portrait_unchecked);
					 localviewHolder.content.setBackgroundColor(Color.rgb(27, 150, 255));
				 }
				 if (gen.equals("女")) {
					 localviewHolder.icon.setBackgroundResource(R.drawable.ic_girl_portrait_unchecked);
					 localviewHolder.content.setBackgroundColor(Color.rgb(250, 100, 30));
				}
			}
			  if (mId.equals(itemlist.get(paramInt).getId()+"")) {
				  localviewHolder.content.setBackgroundColor(Color.rgb(10, 230, 30));
				  
			}
			if ( itemlist.get(paramInt).isNull() ) {
				
				localviewHolder.layout.setVisibility(View.INVISIBLE);
				
			}
			
			
		}
		return paramView;

	}

	class viewHolder {
		TextView   content;
		ImageView icon;
		LinearLayout layout;
		
	}
}
