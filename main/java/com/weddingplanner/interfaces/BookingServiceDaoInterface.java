package com.weddingplanner.interfaces;

import com.weddingplannr.model.BookingServices;

public interface BookingServiceDaoInterface {
	public void bookService(BookingServices bookService) ;
	public int totalPackage(int userId);

}
