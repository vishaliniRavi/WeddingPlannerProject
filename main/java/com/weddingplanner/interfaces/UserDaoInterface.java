package com.weddingplanner.interfaces;

import java.util.List;

import com.weddingplannr.model.User;

public interface UserDaoInterface {
	public void insertUser(User user);
	public User validateUser(String email_id,String password);
	public User validateAdmin(String email_id,String password);
	public void updateUserProfile(User user);
	public User validateUserUpdate(String email_id);
	public List<User> viewUser();
	public  int findUserId(String emailId);
	public int walletbal(int id) ;
	public int updatewallet(int amount,int userId);

}
