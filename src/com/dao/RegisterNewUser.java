package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.TripDtls;
import com.pojo.User;

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
	public User fetchUserDetailsByUserIdPassword(String userName, String pass) {
		Statement stmt = null;
		Connection conn = null;
		User usr= null;
		try {
			usr= new User();
			DBconnection dbc = new DBconnection();
			conn = dbc.getConnection();
			

			stmt = conn.createStatement();

			String sql = "SELECT id, email, address, username FROM trip.user where username = '" + userName + "' and password = '" + pass +"'";
//			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
			usr.setId(rs.getInt("id"));
			usr.setAddress(rs.getString("address"));
			usr.setName(rs.getString("username"));
			usr.setEmail(rs.getString("email"));
		        
		    }
			return usr;

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		return usr;
	}

	// create trip
	
	public boolean createNewTrip(String from, String to, String start, String end,String distance, int uid ,String date)
	{
		Statement st = null;
		Connection con = null;
		
		try
		{
			DBconnection obj = new DBconnection();
			con = obj.getConnection();
			st = con.createStatement();
			String sql ="INSERT INTO `trip`.`tour` (`from`, `to`, `distance`, `start`,`end`,`UID`,`date`) VALUES ('"+ from +"','"  + to +"','" + distance +"','" + start +"','" + end +"','" + uid +"','" + date +"')";
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
	
	// trip dtls
	public List<TripDtls> fetchtripDtls(int uid) {
		Statement stmt = null;
		Connection conn = null;
		TripDtls trip=null;
		List<TripDtls> tr = new ArrayList<TripDtls>();
		try {
			DBconnection dbc = new DBconnection();
			conn = dbc.getConnection();
			

			stmt = conn.createStatement();

			String sql = "SELECT * FROM trip.tour where UID = '" + uid + "' ";
//			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				trip= new TripDtls();
				trip.setId(rs.getInt("idtour"));
				trip.setFrom(rs.getString("from"));
				trip.setTo(rs.getString("to"));
				trip.setDistance(rs.getString("distance"));
				trip.setDate(rs.getString("date"));
				trip.setStart(rs.getString("start"));
				trip.setEnd(rs.getString("end"));
				tr.add(trip);
			//	System.out.println(trip.getFrom());
		    }
			return tr;

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		return tr;
	}
	
	// filter trip dtls
		public List<TripDtls> filterTrip(int uid,String date) {
			Statement stmt = null;
			Connection conn = null;
			TripDtls trip=null;
			List<TripDtls> tr = new ArrayList<TripDtls>();
			try {
				DBconnection dbc = new DBconnection();
				conn = dbc.getConnection();
				

				stmt = conn.createStatement();

				String sql = "SELECT * FROM trip.tour where UID = '" + uid + "' and date ='"+date+"' ";
//				System.out.println(sql);

				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					trip= new TripDtls();
					trip.setId(rs.getInt("idtour"));
					trip.setFrom(rs.getString("from"));
					trip.setTo(rs.getString("to"));
					trip.setDistance(rs.getString("distance"));
					trip.setDate(rs.getString("date"));
					trip.setStart(rs.getString("start"));
					trip.setEnd(rs.getString("end"));
					tr.add(trip);
				//	System.out.println(trip.getFrom());
			    }
				return tr;

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			}
			return tr;
		}
		
		// Delete user
		
		public boolean deleteUser(String tripid) {
			// TODO Auto-generated method stub
			boolean tempStatus=false;
			try {
			
				DBconnection dbc = new DBconnection();
				//Connection conn = dbc.getDBConnection();
				
				PreparedStatement ps;
				

			
				ps= dbc.getConnection().prepareStatement("DELETE FROM `trip`.`tour` WHERE `idtour` = ? ");
				
				
		
				ps.setString(1, tripid);
				
				
				if(ps.executeUpdate()>0) {
					tempStatus= true;
				}
					
				
				

			} catch (Exception e) {
				e.printStackTrace();
			}

			return tempStatus;
		}
}
