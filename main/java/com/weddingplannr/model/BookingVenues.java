package com.weddingplannr.model;

import java.util.Date;
import java.util.Objects;

public class BookingVenues {
	
	private int user_id;
	private int venue_id;
	private String venueName;
	private int noOfGuest;
	private String functionTiming;
	private Date eventDate;
	private double venuePackage;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getVenue_id() {
		return venue_id;
	}
	public void setVenue_id(int venue_id) {
		this.venue_id = venue_id;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public int getNoOfGuest() {
		return noOfGuest;
	}
	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}
	public String getFunctionTiming() {
		return functionTiming;
	}
	public void setFunctionTiming(String functionTiming) {
		this.functionTiming = functionTiming;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public double getVenuePackage() {
		return venuePackage;
	}
	public void setVenuePackage(double venuePackage) {
		this.venuePackage = venuePackage;
	}
	public BookingVenues(int user_id, int venue_id, String venueName, int noOfGuest, String functionTiming,
			Date eventDate, double venuePackage) {
		super();
		this.user_id = user_id;
		this.venue_id = venue_id;
		this.venueName = venueName;
		this.noOfGuest = noOfGuest;
		this.functionTiming = functionTiming;
		this.eventDate = eventDate;
		this.venuePackage = venuePackage;
	}
	public BookingVenues() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(eventDate, functionTiming, noOfGuest, user_id, venueName, venuePackage, venue_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingVenues other = (BookingVenues) obj;
		return Objects.equals(eventDate, other.eventDate) && Objects.equals(functionTiming, other.functionTiming)
				&& noOfGuest == other.noOfGuest && user_id == other.user_id
				&& Objects.equals(venueName, other.venueName)
				&& Double.doubleToLongBits(venuePackage) == Double.doubleToLongBits(other.venuePackage)
				&& venue_id == other.venue_id;
	}
	@Override
	public String toString() {
		return "BookingVenues [user_id=" + user_id + ", venue_id=" + venue_id + ", venueName=" + venueName
				+ ", noOfGuest=" + noOfGuest + ", functionTiming=" + functionTiming + ", eventDate=" + eventDate
				+ ", venuePackage=" + venuePackage + "]";
	}
	
	
	
	
	
	

}
