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
import com.example.data.BookData;
import com.example.data.ClassRoom;
import com.example.data.Constant;
import com.example.data.FamilyData;

public class BookAdapter extends BaseAdapter {
	private Context context;
	private List<BookData> itemlist;
	private LayoutInflater minflater;
	private Handler mHandler;
	private int mMode;

	public BookAdapter(Context paramContext, List<BookData> paramArrayList,
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
			paramView = this.minflater.inflate(R.layout.adp_bookint,
					paramViewGroup, false);
			localviewHolder.content = ((TextView) paramView
					.findViewById(R.id.adp_familyname));
			
			localviewHolder.contenta = ((TextView) paramView
					.findViewById(R.id.adp_familynamea));
			localviewHolder.contentb = ((TextView) paramView
					.findViewById(R.id.adp_familynameb));
			localviewHolder.icon = ((ImageView) paramView
					.findViewById(R.id.adp_familyimg));
			localviewHolder.layout=(LinearLayout)paramView.findViewById(R.id.adp_layout);

			paramView.setTag(localviewHolder);
		} else {
			localviewHolder = (viewHolder) paramView.getTag();
		}

		if ((this.itemlist != null) && (this.itemlist.size() > 0)) {

			 String str=itemlist.get(paramInt).getFamily().getSurname()+itemlist.get(paramInt).getFamily().getGenealogy_name()+"  "+
					     itemlist.get(paramInt).getFamily().getPrefix_name()+"  "+itemlist.get(paramInt).getFamily().getTitle_name()+"  "+"" +
					     itemlist.get(paramInt).getFamily().getGender()	
					 ;
			 if (str!=null) {
				 str=str.replace("null", "");
				 localviewHolder.contenta.setText(str+"");
			   }
			 
				localviewHolder.content.setText( (itemlist.get(paramInt).getGerner() +1)+"世(辈)");
			 
				 
				 String stra =null
					 ;
				//  if (itemlist.get(paramInt).getFamily().getAd_birth()>0) {
					  stra=(itemlist.get(paramInt).getFamily().getAd_birth());
				//}
				  
				 // if (itemlist.get(paramInt).getFamily().getAd_death()>0) {
					  stra=stra+"-"+(itemlist.get(paramInt).getFamily().getAd_death());
				 //   }
			 if (stra!=null) {
				 stra=stra.replace("null", "");
				 localviewHolder.contentb.setText(stra+"");
			   }
				
		}
		return paramView;

	}

	class viewHolder {
		TextView   content,contenta,contentb;
		ImageView icon;
		LinearLayout layout;
		
	}
}
