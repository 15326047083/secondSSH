package com.ambow.second.dao.impl;


import com.ambow.second.dao.IUserDao;
import com.ambow.second.entity.User;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
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

    public List<User> queryAll(int index) {  //当前页
        Query query = sessionFactory.getCurrentSession().createQuery("from User where num<>123456");
        ScrollableResults scrollableResults=query.scroll();
        scrollableResults.last();
        int i = scrollableResults.getRowNumber() + 1;
        ServletActionContext.getRequest().getSession().setAttribute("page", i);
        query.setFirstResult((index-1) * 10);
        query.setMaxResults(10);
        return query.list();
    }

    /**
     * 删除用户，，修改alive状态
     *
     * @param user
     */
    @Override
    @Transactional
    public void updateAlive(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    /**
     * 模糊查询
     *
     * @param selectKey
     * @return
     */
    @Override
    @Transactional
    public List<User> likeSelect(String selectKey,int index) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where num<>123456 and (name like '%" + selectKey + "%' or num like '%" + selectKey + "%' or phone like '%" + selectKey + "%')");
        ScrollableResults scrollableResults=query.scroll();
        scrollableResults.last();
        int i = scrollableResults.getRowNumber() + 1;
        ServletActionContext.getRequest().getSession().setAttribute("page", i);
        query.setFirstResult((index-1) * 10);
        query.setMaxResults(10);
        return query.list();
    }

    /**
     * 根据num查询
     *
     * @param num
     * @return
     */
    @Override
    @Transactional
    public User getByNum(int num) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where num=" + num).uniqueResult();
    }

}
