package com.weddingplanner.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.weddingplanner.dao.UserDao;
import com.weddingplanner.module.User;
import com.weddingplanner.module.Venues;
import com.weddingplanner.util.ConnectionUtil;



public class UserDaoimpl implements UserDao{
	public void insertUser(User user) {
   	 String insertQuery="insert into user_details(user_name, mobile_number, city, email_id, password) values(?,?,?,?,?)";
   	 ConnectionUtil conUtil=new ConnectionUtil();
   	 Connection con=conUtil.getDbConnection();
   	 PreparedStatement prstmt=null;
   	 try {
			prstmt=con.prepareStatement(insertQuery);
			prstmt.setString(1, user.getUserName());
			prstmt.setLong(2, user.getMobileNumber());
			prstmt.setString(3, user.getCity());
			prstmt.setString(4, user.getEmailId());
			prstmt.setString(5, user.getPassword());
			prstmt.executeUpdate();
			System.out.println("Registered successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("values not inserted");
			
		}
   	 
    }
    public User validateUser(String email_id,String password) {
   	 String validateQuery="select * from user_details where email_id='"+email_id+ "'and password='"+password+"'and user_role='customer' ";
   	 Connection con=ConnectionUtil.getDbConnection();
   	 User user = null;
   	 try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(validateQuery);
			if(rs.next())
			{
				user=new User(rs.getString(3),rs.getLong(4),rs.getString(5),email_id,password,rs.getInt(6));
			}
			else {
				System.out.println("Not a valid user");
			}
   	 }catch (SQLException e) 
   	 {
			// TODO Auto-generated catch block
			e.printStackTrace();
   	 }
   	 return user;
    }
    public User validateAdmin(String email_id,String password){
    	
    	String validateAdminQuery="select * from user_details where user_role='admin'and email_id='"+email_id+"'and password='"+password+"'" ;
    	Connection con=ConnectionUtil.getDbConnection();
    	User user=null;
    	try {
			Statement stmt =con.createStatement();
			ResultSet rs=stmt.executeQuery(validateAdminQuery);
			if(rs.next()) {
				user=new User(rs.getString(3),rs.getLong(4),rs.getString(5),email_id,password,rs.getInt(8));
			}
//			else {
//				System.out.println("not a valid user");
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return user;
    	
    }
	
	public void updateUserProfile(User user) {
		String updateQuery="update user_details set user_name=?,mobile_number=?,city=?,password=? where email_id=?";
		Connection con=ConnectionUtil.getDbConnection();
		PreparedStatement prstmt=null;
		try {
			prstmt=con.prepareStatement(updateQuery);
			prstmt.setString(1, user.getUserName());
			prstmt.setLong(2, user.getMobileNumber());
			prstmt.setString(3, user.getCity());
			prstmt.setString(4,user.getPassword());
			prstmt.setString(5, user.getEmailId());
			prstmt.executeUpdate();
			System.out.println("profile edited successfully");
		} catch (SQLException e) {
			// TODO Auto-generated cat;
			e.printStackTrace();
		}
	
		
		    }
	 public User validateUserUpdate(String email_id) {
	   	 String validateUpdateQuery="select * from user_details where email_id='"+email_id+ "'";
	   	 Connection con=ConnectionUtil.getDbConnection();
	   	 User user = null;
	   	 try {
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(validateUpdateQuery);
				if(rs.next())
				{
					user=new User(rs.getString(3),rs.getLong(4),rs.getString(5),email_id,rs.getString(7),rs.getInt(8));
				}
				else {
					System.out.println("Not a valid user");
				}
	   	 }catch (SQLException e) 
	   	 {
				// TODO Auto-generated catch block
				e.printStackTrace();
	   	 }
	   	 return user;
	}
	
	 public List<User> viewUser(){
		 List<User> userList=new ArrayList<User>();
		 String showQuery="select * from user_details where user_role='customer'";
		 Connection con=ConnectionUtil.getDbConnection();
		 try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			while(rs.next()) {
				User user=new User(rs.getString(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				userList.add(user);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
		
	 
	 }public  int findUserId(String emailId)
		{
			String findUser="select User_id from user_details where email_id='"+emailId+"'";
			Connection con=ConnectionUtil.getDbConnection();
			int userId=0;
			try {
				Statement stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(findUser);
				if(rs.next())
				{
				userId=rs.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return userId;
	 
}
	//get wallet balance:
		public int walletbal(int id) 
		{
			Connection con = ConnectionUtil.getDbConnection();
			String query = "select user_wallet from user_details where user_id = ?";
			PreparedStatement statement;
			try {
				statement = con.prepareStatement(query);
				statement.setInt(1, id);
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
						return rs.getInt(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		}
			
		
		//update wallet balance:
		public int updatewallet(int amount,int userId) {
			Connection con = ConnectionUtil.getDbConnection();
			String query = "update user_details set user_wallet = ? where user_id = ?";
			PreparedStatement statement;
			int res=0;
			try {
				statement = con.prepareStatement(query);
				statement.setInt(1,amount);
				statement.setInt(2, userId);
				 res = statement.executeUpdate();
				 statement.executeUpdate("commit");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return res;
		}

	
}