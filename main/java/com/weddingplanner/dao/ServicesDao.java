package com.weddingplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.weddingplanner.interfaces.ServicesDaoInterface;
import com.weddingplannr.model.Services;
import com.weddingplannr.model.User;

public class ServicesDao implements ServicesDaoInterface {
	public List<Services> showServices(){
		List<Services> serviceList =new ArrayList<Services>();
		String viewQuery="select * from service_details";
		Connection con=ConnectionUtil.getDbConnection();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(viewQuery);
			while(rs.next()) {
			Services service=new Services(rs.getString(2),rs.getDouble(3));
			serviceList.add(service);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
     return serviceList;
		
	}
	public void insertService(Services service) {
		String insertQuery="insert into service_details(service_name,service_package)values(?,?)";
	     ConnectionUtil conUtil=new ConnectionUtil();
	     Connection con=conUtil.getDbConnection();
	     try {
			PreparedStatement prstmt=con.prepareStatement(insertQuery);
			prstmt.setString(1, service.getServiceName());
			prstmt.setDouble(2, service.getServicePackage());
			prstmt.executeUpdate();
			System.out.println("service added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 public void removeServices(String serviceName) {
			String deleteQuery="delete from Service_details where service_name=?";
			ConnectionUtil conUtil=new ConnectionUtil();
			Connection con=conUtil.getDbConnection();
			try {
				PreparedStatement prstmt=con.prepareStatement(deleteQuery);
				prstmt.setString(1,serviceName);
				int noOfRows=prstmt.executeUpdate();
				System.out.println(noOfRows+ "row deleted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 
	 
	 public int findServiceId() {
		 String findVenue="select service_id from service_details where service_name='photography'";
		 Connection con=ConnectionUtil.getDbConnection();
			int serviceId=0;
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(findVenue);
				if(rs.next()) {
					serviceId=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 return serviceId;
	
	}
	 public  double findPackage(int serviceId)
		{
			String query="select service_package from service_details where service_id='"+serviceId+"'";
			
			Connection con=ConnectionUtil.getDbConnection();
			Statement stmt;
			double servicePackage=0;
			try {
				stmt=con.createStatement();
				
				ResultSet rs=stmt.executeQuery(query);
				
				if(rs.next())
				{
					servicePackage=rs.getDouble(1);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			return servicePackage;
			
		}
	 public int findMehandiId() {
		 String findVenue="select service_id from service_details where service_name='Mehandi'";
		 Connection con=ConnectionUtil.getDbConnection();
			int serviceId=0;
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(findVenue);
				if(rs.next()) {
					serviceId=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 return serviceId;
	
	}
	 public int findMakeupId() {
		 String findVenue="select service_id from service_details where service_name='Bridal Makeup'";
		 Connection con=ConnectionUtil.getDbConnection();
			int serviceId=0;
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(findVenue);
				if(rs.next()) {
					serviceId=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 return serviceId;
	
	}
	 public int findDecorationId() {
		 String findVenue="select service_id from service_details where service_name='Decoration'";
		 Connection con=ConnectionUtil.getDbConnection();
			int serviceId=0;
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(findVenue);
				if(rs.next()) {
					serviceId=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 return serviceId;
	
	}
	 public int updateRatingProfile(int ratings) {
			String updateQuery="update service_details set ratings=?";
			Connection con=ConnectionUtil.getDbConnection();
			PreparedStatement prstmt=null;
			try {
				prstmt=con.prepareStatement(updateQuery);
                prstmt.setInt(1, ratings);
				System.out.println("profile edited successfully");
			} catch (SQLException e) {
				// TODO Auto-generated cat;
				e.printStackTrace();
			}
		 return ratings;
		} 
	 
}
