package com.example.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 */

public class FamilySql extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "family.db";
	private static final int SCHEMA_VERSION = 1;

	public FamilySql(Context context) {
		super(context, DATABASE_NAME, null, SCHEMA_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL("CREATE TABLE  IF NOT EXISTS Login_Info (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,longinState INT);");
 		db.execSQL("CREATE TABLE  IF NOT EXISTS User_Info (_id INTEGER PRIMARY KEY AUTOINCREMENT,user TEXT,password TEXT,dates LONG);");
 		db.execSQL("CREATE TABLE  IF NOT EXISTS genealogy (gid  INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,theme TEXT,hall_name TEXT,tag_name TEXT,location TEXT,create_by TEXT,create_time TEXT,update_by TEXT,update_time LONG,del_flag TEXT,description TEXT,cate TEXT);");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public void deleteRecordId(int id) {
		SQLiteDatabase db = this.getWritableDatabase();

		db.execSQL("delete from User_Info where _id= " + id);
	}

	public void addRecord(String name, int steps, long diru, long dates) {
		ContentValues cv = new ContentValues();
		SQLiteDatabase db = this.getWritableDatabase();

		cv.put("user", name);
		cv.put("steps", steps);
		cv.put("diru", diru);
		cv.put("dates", dates);

		db.insert("User_Info", null, cv);

	}

	public Cursor getRecord(String where, String orderBy) {
		StringBuilder buf = new StringBuilder("SELECT * FROM User_Info");
		SQLiteDatabase db = this.getWritableDatabase();
		if (where != null) {
			buf.append(" WHERE ");
			buf.append(where);
		}

		if (orderBy != null) {
			buf.append(" ORDER BY ");
			buf.append(orderBy);
		}

		return (db.rawQuery(buf.toString(), null));
	}

	public void updatemoneysName(String newName, String name) {
		SQLiteDatabase db = this.getWritableDatabase();

		db.execSQL("UPDATE User_Info SET user = " + newName + " WHERE user = "
				+ "'" + name + "'");
		db.close();
	}

	public void deleteAllRecord(String name) {
		SQLiteDatabase db = this.getWritableDatabase();

		db.execSQL("delete from User_Info where user= " + "'" + name + "'");
	}

	
	
	
	public void addNewUser(String name, int longinState) {

		ContentValues cv = new ContentValues();
		SQLiteDatabase db = this.getWritableDatabase();

		cv.put("name", name);
		cv.put("longinState", longinState);
		db.insert("Login_Info", null, cv);
		db.close();
	}

	public Cursor getUserApp(String where, String orderBy) {
		//
		StringBuilder buf = new StringBuilder("SELECT * FROM Login_Info");
		SQLiteDatabase db = this.getWritableDatabase();
		if (where != null) {
			buf.append(" WHERE ");
			buf.append(where);
		}

		if (orderBy != null) {
			buf.append(" ORDER BY ");
			buf.append(orderBy);
		}

		return (db.rawQuery(buf.toString(), null));
	}

	public void updateUserPassword(int longinState, String name) {
		SQLiteDatabase db = this.getWritableDatabase();

		db.execSQL("UPDATE Login_Info SET longinState = " + longinState
				+ " WHERE name = " + "'" + name + "'");
		db.close();
	}

	public void deleteAllUser() {
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("delete from Login_Info");
		db.close();
	}

}
