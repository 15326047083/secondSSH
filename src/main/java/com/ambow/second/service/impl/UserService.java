package com.ambow.second.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambow.second.dao.IUserDao;
import com.ambow.second.entity.User;
import com.ambow.second.service.IUserService;

import javax.management.Query;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> queryAll() {
        // TODO Auto-generated method stub
        return userDao.queryAll();
    }

    public User findUserById(User user){
        userDao.findUserById(user);
        return null;
    }
    /*@Override
    public boolean updateUserById(User user) {
        try{
            userDao.updateUserById(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }*/

}
