package com.ambow.second.service;

import java.util.List;

import com.ambow.second.entity.User;

public interface IUserService {

	List<User> queryAll();
	// 根据用户ID查询用户
	User findUserById(User user);
    // 修改用户信息
	String saveOrUpdate(User user);
	// 删除用户
	String delete(User user);

}
