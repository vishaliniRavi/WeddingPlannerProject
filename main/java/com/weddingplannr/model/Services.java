package com.weddingplannr.model;

import java.util.Objects;

public class Services {
	private String serviceName;
	private double servicePackage;
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
	public Services(String serviceName, double servicePackage) {
		super();
		this.serviceName = serviceName;
		this.servicePackage = servicePackage;
	}
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(serviceName, servicePackage);
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
		return Objects.equals(serviceName, other.serviceName)
				&& Double.doubleToLongBits(servicePackage) == Double.doubleToLongBits(other.servicePackage);
	}
	@Override
	public String toString() {
		return "Services [serviceName=" + serviceName + ", servicePackage=" + servicePackage + "]";
	}
	
	

}
