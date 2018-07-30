package com.ambow.second.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ambow.second.dao.IUserDao;
import com.ambow.second.entity.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDao implements IUserDao {
    // springboot会默认自动将数据源中的配置注入,
    // 用法与hibernate中sessionFactory生成的session类似。以后使用多数据源时会详细解释

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdate(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> get() {
        // TODO Auto-generated method stub
        return (List<User>) sessionFactory.getCurrentSession().createQuery("FROM User").list();
    }
}
