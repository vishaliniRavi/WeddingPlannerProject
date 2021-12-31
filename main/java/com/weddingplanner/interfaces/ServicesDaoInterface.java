package com.weddingplanner.interfaces;

import java.util.List;

import com.weddingplannr.model.Services;

public interface ServicesDaoInterface {
	public List<Services> showServices();
	public void insertService(Services service);
	 public void removeServices(String serviceName);
	 public int findServiceId();
	 public  double findPackage(int serviceId);
	 public int findMehandiId();
	 public int findMakeupId();
	 public int findDecorationId();
	 
}
