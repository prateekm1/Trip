package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterNewUser {

	public boolean registerNewUser(String name, String email, String address, String password)
	{
		Statement st = null;
		Connection con = null;
		
		try
		{
			DBconnection obj = new DBconnection();
			con = obj.getConnection();
			st = con.createStatement();
			String sql ="INSERT INTO `trip`.`user` (`username`, `email`, `address`, `password`) VALUES ('"+ name +"','"  + email +"','" + address +"','" + password +"')";
			st.executeUpdate(sql);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			 try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
		return false;
	}
}
