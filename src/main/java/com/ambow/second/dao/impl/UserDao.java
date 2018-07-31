package com.ambow.second.dao.impl;


import com.ambow.second.dao.IUserDao;
import com.ambow.second.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends CommonDao<User> implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;
    
}
