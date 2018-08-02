package com.ambow.second.dao;

import com.ambow.second.entity.User;

import java.util.List;


public interface IUserDao extends ICommonDao<User> {

    List<User> queryAll();

    // 删除用户
    void updateAlive(User user);

    // 模糊查询
    List listSelect(String selectKey);

    User getByNum(int num);
}
