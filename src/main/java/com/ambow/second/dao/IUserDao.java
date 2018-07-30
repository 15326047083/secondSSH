package com.ambow.second.dao;

import java.util.List;

import com.ambow.second.entity.User;


public interface IUserDao {
	void saveOrUpdate(User user);

	List<User> get();
}
