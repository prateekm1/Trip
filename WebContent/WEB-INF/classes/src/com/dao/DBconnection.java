package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

	public Connection getConnection()
	{
		Connection con = null;
		String dbUser = "root";
		String dbPass = "";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trip?useSSL=false", dbUser, dbPass);
			return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
