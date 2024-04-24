package com.example.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constant {
	//public static final String url = "http://172.20.10.2:8080/CFamilySer/";
	public static final String url = "http://10.0.2.2:8081/CFamilySer/";
	public static int CATE_SELF=0;
	public static final int CATE_FATHER=1,CATE_MOTHER=2,CATE_WIFE=3,CATE_BROTER=4,CATE_SISTER=5,CATE_SON=6,CATE_DAU=7;
	public static final String ALIVE_YES="0",ALIVE_NO="1";
	
	public static final int CHOI_A=0,CHOI_B=1,CHOI_C=2,CHOI_D=3;
	public static final String ADD="请复制此句，打开家谱App自动加入家族，%ESDFWE$SERA*SFAEWFFF";
	public static String dayFormat(long time) {
		// 获取特定时间格式,
		String s = "null";
		SimpleDateFormat formate = new SimpleDateFormat("yyyy年MM月dd日");
		s = formate.format(new Date(time));
		return s;
	}

}
