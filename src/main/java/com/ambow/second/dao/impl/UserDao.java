package com.ambow.second.dao.impl;


import com.ambow.second.dao.IUserDao;
import com.ambow.second.entity.User;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDao extends CommonDao<User> implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void updateAlive(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    /**
     * 模糊查询
     * @param selectKey
     * @return
     */
    @Override
    public List<User> likeSelect(String selectKey) {
        return sessionFactory.getCurrentSession().createQuery("from User where name like '%"+selectKey+"%' or num like '%"+selectKey+"%' or phone like '%"+selectKey+"%' or deptId like '%"+selectKey+"%'").list();
    }

    /**
     * 根据num查询
     * @param num
     * @return
     */
    @Override
    public User getByNum(int num) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where num=" + num).uniqueResult();
    }

}
