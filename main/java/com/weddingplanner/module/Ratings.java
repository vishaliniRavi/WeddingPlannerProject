package com.weddingplanner.module;

import java.util.Objects;

public class Ratings {
     private int userId;
     private String serviceName;
     private int rating;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Ratings(int userId, String serviceName, int rating) {
		super();
		this.userId = userId;
		this.serviceName = serviceName;
		this.rating = rating;
	}
	public Ratings() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(rating, serviceName, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ratings other = (Ratings) obj;
		return rating == other.rating && Objects.equals(serviceName, other.serviceName) && userId == other.userId;
	}
	@Override
	public String toString() {
		return "ratings [userId=" + userId + ", serviceName=" + serviceName + ", rating=" + rating + "]";
	}
     
     
	
     
}
