package com.example.data;

public class BookData {
int gid  ;     // --族谱id
String name  ;   // --族谱名称
String theme  ;  //  --族谱的主题
String hall_name  ; // --郡望
String 	tag_name  ; // --堂号
String	location  ;   //--所在地区（此处可以根据需要进行改变，古今地名不同）

FamilyData family;
int gerner;



public FamilyData getFamily() {
	return family;
}
public void setFamily(FamilyData family) {
	this.family = family;
}
public int getGerner() {
	return gerner;
}
public void setGerner(int gerner) {
	this.gerner = gerner;
}
public int getGid() {
	return gid;
}
public void setGid(int gid) {
	this.gid = gid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTheme() {
	return theme;
}
public void setTheme(String theme) {
	this.theme = theme;
}
public String getHall_name() {
	return hall_name;
}
public void setHall_name(String hall_name) {
	this.hall_name = hall_name;
}
public String getTag_name() {
	return tag_name;
}
public void setTag_name(String tag_name) {
	this.tag_name = tag_name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}



}
