package com.ambow.second.dao;

import com.ambow.second.entity.User;

import java.util.List;


public interface IUserDao extends ICommonDao<User> {
    //  查询所有用户
    List<User> queryAll();
    // 删除用户
    void updateAlive(User user);
    // 模糊查询
    List<User> likeSelect(String selectKey);
    //  根据num查询
    User getByNum(int num);
}
