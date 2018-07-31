package com.ambow.second.dao.impl;

import org.springframework.stereotype.Repository;

import com.ambow.second.dao.IUserDao;
import com.ambow.second.entity.User;

@Repository
public class UserDao extends CommonDao<User> implements IUserDao {
}
