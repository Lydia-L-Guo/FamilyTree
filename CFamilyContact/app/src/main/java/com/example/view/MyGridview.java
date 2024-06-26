package com.example.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class MyGridview extends GridView{
      private Context context;

	 public MyGridview(Context context, AttributeSet attrs) { 
			super(context, attrs); 
		} 
	 public MyGridview(Context context) { 
			super(context); 	} 
	 
	   /**
		 * 设置不滚动 
		 * 
		 * 其中onMeasure函数决定了组件显示的高度与宽度；
		 * makeMeasureSpec函数中第一个函数决定布局空间的大小，第二个参数是布局模式
		 * MeasureSpec.AT_MOST的意思就是子控件需要多大的空间就扩展到多大的空间
	 
		 */
		@Override 
		protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { 
			int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST); 
			super.onMeasure(widthMeasureSpec, expandSpec); 
		} 
 
}
