package com.example.dao;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class LoginDao {

	public static final String driver = "com.mysql.jdbc.Driver";//
	// public static final String URL="jdbc:mysql://127.0.0.1:3306/cfamilycontact";
	public static final String URL = "jdbc:mysql://localhost:3306/cfamilycontact?useSSL=false";
	String code = "?useUnicode=true&characterEncoding=UTF";
	public static final String NAME = "root";
	public static final String PASSWORD = "58802793linda";

	private static Connection conn = null;

	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager
					.getConnection(URL, NAME, PASSWORD);
			System.out
					.println(" ------------------------------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out
					.println("------------------------------------------------");
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {

		if (conn == null) {

			conn = (Connection) DriverManager
					.getConnection(URL, NAME, PASSWORD);
			return conn;

		} else {
			return conn;
		}

	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		Connection conns = LoginDao.getConnection();
		if (conns != null) {
			System.out
					.println("------------------------------------------------");

		}

	}

}
