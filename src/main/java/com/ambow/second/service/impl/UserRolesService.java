package com.ambow.second.service.impl;

import com.ambow.second.dao.IUserRolesDao;
import com.ambow.second.service.IUserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRolesService implements IUserRolesService {
    @Autowired
    private IUserRolesDao userRolesDao;

    @Override
    public List<String> getRolesByNum(String userName) {
        return userRolesDao.getRolesByNum(userName);
    }
}
