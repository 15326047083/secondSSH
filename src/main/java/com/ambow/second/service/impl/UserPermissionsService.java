package com.ambow.second.service.impl;

import com.ambow.second.dao.IUserPermissionsDao;
import com.ambow.second.service.IUserPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPermissionsService implements IUserPermissionsService {
    @Autowired
    private IUserPermissionsDao userPermissionsDao;

    @Override
    public List<String> getByRoles(String str) {
        return userPermissionsDao.getByRoles(str);
    }
}
