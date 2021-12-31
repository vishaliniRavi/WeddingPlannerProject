package com.weddingplanner.interfaces;

import java.util.List;

import com.weddingplannr.model.Venues;

public interface VenuesDaoInterface {
	public List<Venues> showVenue();
	public void insertVenue(Venues venue);
	public void removeVenue(String venueName);
	public void updateVenue(String venueVendorName,long contactNumber,double venuePackage,String venueName);
	public int findVenueId(String venueName);
	public  int findPackage(int venueId);
	public List<Venues> findCity(String venueCity);
	public List<Venues> findByBudget();
	public List<Venues> findLuxury();
	
}
