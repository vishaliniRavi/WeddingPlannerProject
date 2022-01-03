package com.weddingplanner.dao;

import java.util.List;

import com.weddingplanner.module.Services;

public interface ServicesDao {
	public List<Services> showServices();
	public void insertService(Services service);
	 public void removeServices(String serviceName);
	 public int findServiceId();
	 public  double findPackage(int serviceId);
	 public int findMehandiId();
	 public int findMakeupId();
	 public int findDecorationId();
	 
}
