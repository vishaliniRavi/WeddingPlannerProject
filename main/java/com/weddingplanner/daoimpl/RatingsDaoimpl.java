package com.weddingplanner.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.weddingplanner.module.Ratings;
import com.weddingplanner.module.Services;
import com.weddingplanner.module.User;
import com.weddingplanner.module.Venues;
import com.weddingplanner.util.ConnectionUtil;

public class RatingsDaoimpl {
	public void insertRating(Ratings rating) {
		String insertQuery="insert into rating_details(user_id,service_name,rating)values(?,?,?)";
	     ConnectionUtil conUtil=new ConnectionUtil();
	     Connection con=conUtil.getDbConnection();
	     try {
			PreparedStatement prstmt=con.prepareStatement(insertQuery);
			prstmt.setInt(1, rating.getUserId());
			prstmt.setString(2, rating.getServiceName());
			prstmt.setInt(3, rating.getRating());
			prstmt.executeUpdate();
			System.out.println("thank you !!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Ratings> rating(){
		 List<Ratings> ratelist=new ArrayList<Ratings>();

		String viewQuery="select service_name,trunc((sum(rating)/count(rating)),3)  from  rating_details  group by service_name";
		Connection con=ConnectionUtil.getDbConnection();
        Ratings rating=null;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(viewQuery);
			while(rs.next()) {
			    rating=new Ratings(rs.getInt(1),rs.getString(2),rs.getInt(3));
			    ratelist.add(rating);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ratelist;
		
     
 }	

}
