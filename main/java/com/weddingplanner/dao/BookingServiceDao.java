package com.weddingplanner.dao;

import com.weddingplanner.module.BookingServices;

public interface BookingServiceDao {
	public void bookService(BookingServices bookService) ;
	public int totalPackage(int userId);

}
