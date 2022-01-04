package com.weddingplanner.module;

import java.util.Objects;

public class Services {
	private String serviceName;
	private double servicePackage;
	private String serviceImages;
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getServicePackage() {
		return servicePackage;
	}
	public void setServicePackage(double servicePackage) {
		this.servicePackage = servicePackage;
	}
	public String getServiceImages() {
		return serviceImages;
	}
	public void setServiceImages(String serviceImages) {
		this.serviceImages = serviceImages;
	}
	public Services(String serviceName, double servicePackage, String serviceImages) {
		super();
		this.serviceName = serviceName;
		this.servicePackage = servicePackage;
		this.serviceImages = serviceImages;
	}
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Services [serviceName=" + serviceName + ", servicePackage=" + servicePackage + ", serviceImages="
				+ serviceImages + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(serviceImages, serviceName, servicePackage);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Services other = (Services) obj;
		return Objects.equals(serviceImages, other.serviceImages) && Objects.equals(serviceName, other.serviceName)
				&& Double.doubleToLongBits(servicePackage) == Double.doubleToLongBits(other.servicePackage);
	}
	
	
	
	
}
