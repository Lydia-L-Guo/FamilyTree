package com.example.data;

public class FamilyData {
/**
 * 	是否是标题和空格
 */
boolean isPh,isNull;
boolean isCoupleStart;//是否是夫妻起始位置


 int	id  ;        // --唯一性编码，将来可以换成其他的如GUID
 int gid ;        //--族谱ID
String	surname  ;  // --姓
String	genealogy_name  ;  //--谱名
String	gender  ;  //--性别
String	ad_birth   ;  //--公元纪年出生年月日
String	ad_death  ; //--公元纪年逝世年月日
String	spouse  ;     //--配偶
String	father_id  ;  // --存放父亲的ID，约定第一个元素存放血缘父亲，第二个存放收养关系父亲，从第三个开始存放肩挑
String	mother_id  ;  // --存放母亲的ID，约定第一个元素存放血缘母亲，第二个存放收养关系母亲，从第三个存放肩挑母亲。
int	generation  ;   // --世代
String	rank  ;      // --0，1，2…代表老大老二老三…

String	prefix_name  ; // --字
String	title_name  ;   // --号
String	common_name;   // --常用名
String	line_name;       // --行号
String	ce_birth  ;    //--年号纪年出生年月日（备用）
String	ce_death  ;   // --年号纪年逝世年月日（备用）
String	alive_flag  ;   //--0表示健在，2表示已故
String	show_flag  ;  // --行传显隐，0表示显示，2表示隐藏
String	biography  ;  // --个人生平简介，
String	epitaph  ;  // --墓志铭
String	birth_place  ; // --出生地
String	death_place  ; //--逝世地
String create_by ;    //--创建者
long create_time ;     //--创建时间
String update_by ;//      --更新者
long update_time ;//      --更新时间
String del_flag ; // --0,表示存在，2表示删除




public String getCreate_by() {
	return create_by;
}
public void setCreate_by(String create_by) {
	this.create_by = create_by;
}
public long getCreate_time() {
	return create_time;
}
public void setCreate_time(long create_time) {
	this.create_time = create_time;
}
public String getUpdate_by() {
	return update_by;
}
public void setUpdate_by(String update_by) {
	this.update_by = update_by;
}
public long getUpdate_time() {
	return update_time;
}
public void setUpdate_time(long update_time) {
	this.update_time = update_time;
}
public String getDel_flag() {
	return del_flag;
}
public void setDel_flag(String del_flag) {
	this.del_flag = del_flag;
}
public boolean isCoupleStart() {
	return isCoupleStart;
}
public void setCoupleStart(boolean isCoupleStart) {
	this.isCoupleStart = isCoupleStart;
}
public boolean isPh() {
	return isPh;
}
public void setPh(boolean isPh) {
	this.isPh = isPh;
}
public boolean isNull() {
	return isNull;
}
public void setNull(boolean isNull) {
	this.isNull = isNull;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getGid() {
	return gid;
}
public void setGid(int gid) {
	this.gid = gid;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getGenealogy_name() {
	return genealogy_name;
}
public void setGenealogy_name(String genealogy_name) {
	this.genealogy_name = genealogy_name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAd_birth() {
	return ad_birth;
}
public void setAd_birth(String ad_birth) {
	this.ad_birth = ad_birth;
}
public String getAd_death() {
	return ad_death;
}
public void setAd_death(String ad_death) {
	this.ad_death = ad_death;
}
public String getSpouse() {
	return spouse;
}
public void setSpouse(String spouse) {
	this.spouse = spouse;
}
public String getFather_id() {
	return father_id;
}
public void setFather_id(String father_id) {
	this.father_id = father_id;
}
public String getMother_id() {
	return mother_id;
}
public void setMother_id(String mother_id) {
	this.mother_id = mother_id;
}
public int getGeneration() {
	return generation;
}
public void setGeneration(int generation) {
	this.generation = generation;
}
public String getRank() {
	return rank;
}
public void setRank(String rank) {
	this.rank = rank;
}
public String getPrefix_name() {
	return prefix_name;
}
public void setPrefix_name(String prefix_name) {
	this.prefix_name = prefix_name;
}
public String getTitle_name() {
	return title_name;
}
public void setTitle_name(String title_name) {
	this.title_name = title_name;
}
public String getCommon_name() {
	return common_name;
}
public void setCommon_name(String common_name) {
	this.common_name = common_name;
}
public String getLine_name() {
	return line_name;
}
public void setLine_name(String line_name) {
	this.line_name = line_name;
}
public String getCe_birth() {
	return ce_birth;
}
public void setCe_birth(String ce_birth) {
	this.ce_birth = ce_birth;
}
public String getCe_death() {
	return ce_death;
}
public void setCe_death(String ce_death) {
	this.ce_death = ce_death;
}
public String getAlive_flag() {
	return alive_flag;
}
public void setAlive_flag(String alive_flag) {
	this.alive_flag = alive_flag;
}
public String getShow_flag() {
	return show_flag;
}
public void setShow_flag(String show_flag) {
	this.show_flag = show_flag;
}
public String getBiography() {
	return biography;
}
public void setBiography(String biography) {
	this.biography = biography;
}
public String getEpitaph() {
	return epitaph;
}
public void setEpitaph(String epitaph) {
	this.epitaph = epitaph;
}
public String getBirth_place() {
	return birth_place;
}
public void setBirth_place(String birth_place) {
	this.birth_place = birth_place;
}
public String getDeath_place() {
	return death_place;
}
public void setDeath_place(String death_place) {
	this.death_place = death_place;
}




}
