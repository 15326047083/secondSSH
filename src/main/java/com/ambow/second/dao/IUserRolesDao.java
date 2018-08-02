package com.ambow.second.dao;

import com.ambow.second.entity.User;

import java.util.List;

public interface IUserRolesDao {
    List<String> getRolesByNum(String Num);

    void deleteRoles(User user);
}
