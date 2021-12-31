package com.weddingplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.weddingplanner.interfaces.BookingServiceDaoInterface;
import com.weddingplannr.model.BookingServices;
import com.weddingplannr.model.BookingVenues;

public class BookingServicesDao implements BookingServiceDaoInterface{
	public void bookService(BookingServices bookService) {
		String insert = "insert into booking_services (user_id,service_id,service_name,event_date,service_package)values(?,?,?,?,?) ";

		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		PreparedStatement prstmt = null;

		try {
			prstmt = con.prepareStatement(insert);
			prstmt.setInt(1, bookService.getUserId());
			prstmt.setInt(2, bookService.getServiceId());
			prstmt.setString(3, bookService.getServiceName());
			prstmt.setString(4, bookService.getEventDate());
			prstmt.setDouble(5, bookService.getServicePackage());
			prstmt.executeUpdate();
			System.out.println("Your services are Successfully booked");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted in the table");
		}
		
}
	public int totalPackage(int userId){
		String query="select sum(service_package) from booking_services where user_id='"+userId+"'group by user_id";
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		int totalPackage=0;
		try {
			stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery(query);
			
			if(rs.next())
			{
				totalPackage=rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return totalPackage;
		
	}
	
	
}