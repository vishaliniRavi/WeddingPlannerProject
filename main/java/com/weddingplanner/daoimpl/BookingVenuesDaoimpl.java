package com.weddingplanner.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.weddingplanner.dao.BookingVenueDao;
import com.weddingplanner.module.BookingVenues;
import com.weddingplanner.module.Venues;
import com.weddingplanner.util.ConnectionUtil;

public class BookingVenuesDaoimpl implements BookingVenueDao{
	
	public void bookVenue(BookingVenues bookVenues) {
//		String bookQuery="insert into booking_venues (user_id,venue_id,venue_name,no_of_guest,function_time,event_date,venue_package) values(?,?,?,?,?,?,?)";
//		ConnectionUtil conUtil=new ConnectionUtil();
//	   	Connection con=conUtil.getDbConnection();
//	   	PreparedStatement prstmt=null;
//	   	UserDao.findUserId(bookQuery);
//	    try {
//			prstmt=con.prepareStatement(bookQuery);
//			String emailId;
//			prstmt.setInt(1, bookVenues.getUserId());
//			prstmt.setInt(2, bookVenues.getVenueId());
//			prstmt.setString(3, bookVenues.getVenueName());
//			prstmt.setInt(4, bookVenues.getNoOfGuest());
//			prstmt.setString(5, bookVenues.getFunctionTiming());
//			prstmt.setString(6,bookVenues.getEventDate());
//			prstmt.setDouble(7,bookVenues.getVenuePackage());
//			prstmt.executeUpdate();
//			System.out.println("Registered successfully");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("values not inserted");
//			
//		}
//   	 
	String insert = "INSERT INTO Booking_venues (user_id,venue_id,venue_name,no_of_guest,function_time,event_date,venue_package) VALUES(?,?,?,?,?,?,?) ";

	ConnectionUtil conUtil = new ConnectionUtil();
	Connection con = conUtil.getDbConnection();
	PreparedStatement prstmt = null;

	try {
		prstmt = con.prepareStatement(insert);
		prstmt.setInt(1, bookVenues.getUser_id());
		prstmt.setInt(2, bookVenues.getVenue_id());
		prstmt.setString(3, bookVenues.getVenueName());
		prstmt.setInt(4, bookVenues.getNoOfGuest());
		prstmt.setString(5, bookVenues.getFunctionTiming());
		prstmt.setDate(6, new java.sql.Date(bookVenues.getEventDate().getTime()));
		prstmt.setDouble(7,bookVenues.getVenuePackage());
		prstmt.executeUpdate();
		System.out.println("Your venue Successfully booked");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Value not inserted in the table");
	}
	   	
	}  	
}  	
	   	
	   	
//	   	boolean result=false;
//	   	
//	   		int userId=0;
//	   		int venueId=0;
//	   		try {
//				Statement stmt =con.createStatement();
//				ResultSet rs=stmt.executeQuery(bookQuery);
//				if(rs.next()) {
//					userId=rs.getInt(1);
//				}
//				userId=UserDao.findUserId(emailId);
//				} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
	   	
	   	
	   	
			
	   	
	
	
	
	
	
	
	


