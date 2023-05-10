package com.abc.springabc.dao;

import java.util.List;

import com.abc.springabc.entity.User;

public interface UserDao {
	
	List<User> getUserList();
	User getUserById(int id);
	void addUser(User user);
	void updateUser(User user);
	void deleterUser(int id);
	

}
