package com.example.model;
 public class FamilyData {
/**
 * 	�Ƿ������кͿո�
 */
boolean isPh,isNull;
boolean isCoupleStart;//�Ƿ��Ƿ�����ʼλ��


 int	id  ;        // --Ψһ�Ա��룬�������Ի�����������GUID
 int gid ;        //--����ID
String	surname  ;  // --��
String	genealogy_name  ;  //--����
String	gender  ;  //--�Ա�
String	ad_birth   ;  //--��Ԫ�������������
String	ad_death  ; //--��Ԫ��������������
String	spouse  ;     //--��ż
String	father_id  ;  // --��Ÿ��׵�ID��Լ����һ��Ԫ�ش��ѪԵ���ף��ڶ������������ϵ���ף��ӵ�������ʼ��ż���
String	mother_id  ;  // --���ĸ�׵�ID��Լ����һ��Ԫ�ش��ѪԵĸ�ף��ڶ������������ϵĸ�ף��ӵ�������ż���ĸ�ס�
int	generation  ;   // --����
String	rank  ;      // --0��1��2�������ϴ��϶�������

String	prefix_name  ; // --��
String	title_name  ;   // --��
String	common_name;   // --������
String	line_name;       // --�к�
String	ce_birth  ;    //--��ż�����������գ����ã�
String	ce_death  ;   // --��ż������������գ����ã�
String	alive_flag  ;   //--0��ʾ���ڣ�2��ʾ�ѹ�
String	show_flag  ;  // --�д�������0��ʾ��ʾ��2��ʾ����
String	biography  ;  // --������ƽ��飬
String	epitaph  ;  // --Ĺ־��
String	birth_place  ; // --������
String	death_place  ; //--������

String create_by ;    //--������
long create_time ;     //--����ʱ��
String update_by ;//      --������
long update_time ;//      --����ʱ��
String del_flag ; // --0,��ʾ���ڣ�2��ʾɾ��


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
