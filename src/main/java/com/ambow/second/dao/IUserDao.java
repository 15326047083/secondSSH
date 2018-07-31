package com.ambow.second.dao;

import com.ambow.second.entity.User;

import java.util.List;


public interface IUserDao extends ICommonDao<User> {

    List<User> queryAll();

}
