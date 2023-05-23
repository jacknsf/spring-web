package com.abc.web.dao;

import java.util.List;

import com.abc.web.entity.User;

public interface UserDao {
	
	List<User> getUserList();
	User getUserById(int id);
	void addUser(User user);
	void updateUser(User user);
	void deleterUser(int id);
	

}
