package com.weddingplannr.model;

import java.util.Objects;

public class BookingServices {
	
	  private int userId;
	  private int serviceId;
	  private String serviceName;
	  private String eventDate;
	  private double servicePackage;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public Double getServicePackage() {
		return servicePackage;
	}
	public void setServicePackage(Double servicePackage) {
		this.servicePackage = servicePackage;
	}
	public BookingServices(int userId, int serviceId, String serviceName, String eventDate, Double servicePackage) {
		super();
		this.userId = userId;
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.eventDate = eventDate;
		this.servicePackage = servicePackage;
	}
	public BookingServices() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(eventDate, serviceId, serviceName, servicePackage, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingServices other = (BookingServices) obj;
		return Objects.equals(eventDate, other.eventDate) && serviceId == other.serviceId
				&& Objects.equals(serviceName, other.serviceName)
				&& Objects.equals(servicePackage, other.servicePackage) && userId == other.userId;
	}
	@Override
	public String toString() {
		return "BookingServices [userId=" + userId + ", serviceId=" + serviceId + ", serviceName=" + serviceName
				+ ", eventDate=" + eventDate + ", servicePackage=" + servicePackage + "]";
	}
	  
	  
	
	

}
