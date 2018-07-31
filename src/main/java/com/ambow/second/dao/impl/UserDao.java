package com.ambow.second.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ambow.second.dao.IUserDao;
import com.ambow.second.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao extends CommonDao<User> implements IUserDao {
    @Autowired
    private SessionFactory sessionFactory;

    

}
