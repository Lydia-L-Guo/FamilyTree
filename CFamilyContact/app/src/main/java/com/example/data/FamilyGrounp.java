package com.example.data;

import java.util.List;

public class FamilyGrounp {
private int generation;
private List<FamilyData> list;

private boolean isNull;


public boolean isNull() {
	return isNull;
}
public void setNull(boolean isNull) {
	this.isNull = isNull;
}
public int getGeneration() {
	return generation;
}
public void setGeneration(int generation) {
	this.generation = generation;
}
public List<FamilyData> getList() {
	return list;
}
public void setList(List<FamilyData> list) {
	this.list = list;
}


}
