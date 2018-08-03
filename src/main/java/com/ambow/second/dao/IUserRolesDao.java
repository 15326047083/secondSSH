package com.ambow.second.dao;

import com.ambow.second.entity.User;
import com.ambow.second.entity.UserRoles;

import java.util.List;

public interface IUserRolesDao extends ICommonDao<UserRoles>{
    List<String> getRolesByNum(String Num);

    void deleteRoles(User user);
}
