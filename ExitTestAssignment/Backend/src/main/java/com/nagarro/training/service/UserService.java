package com.nagarro.training.service;

import com.nagarro.training.entity.User;

public interface UserService {

	// creating user
	public User createUser(User user) throws Exception;

	// get user by username
	public User getUser(String username);

	// delete user by id
	public void deleteUser(int userId);

	// update user by id
	public void updateUser(int userId);

	public User fetchUserByUsernameAndPassword(String username, String password);
}
