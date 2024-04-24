package com.example.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constant {
	public static final String formateDate(long date) {

		String s = "";

		s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(date));
		return s;
	}
	
	public static final String formateDateMin(long date) {

		String s = "";

		s = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(date));
		return s;
	}
	public static float MONEY_HOUR=60;
	public static final  String STATE_ASK=1+"",STATE_NONE=0+"";
	public static String TimeFormat(long time) {
		// 获取特定时间格式,
		String s = "null";
		SimpleDateFormat formate = new SimpleDateFormat("yyyy/MM/dd");
		s = formate.format(new Date(time));
		return s;
	}

	public static int Check=1,UnCheck=0;
	
	
	
	public static long getLong(String str) {
	      long a=0;
		 if (str!=null&&!str.equals("")&&!str.equals("null")) {
			 try {
				 a=Long.parseLong(str);
			} catch (Exception e) {
			}
		   }
		 return a;
	    }
	
	
	public static int getInt(String str) {
	      int a=-1;
		 if (str!=null&&!str.equals("")&&!str.equals("null")) {
			 try {
				 a=Integer.parseInt(str);
			} catch (Exception e) {
			}
		   }
		 return a;
	    }
}
