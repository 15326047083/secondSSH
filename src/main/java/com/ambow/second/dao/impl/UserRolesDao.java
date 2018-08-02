package com.ambow.second.dao.impl;

import com.ambow.second.dao.IUserRolesDao;
import com.ambow.second.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRolesDao implements IUserRolesDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<String> getRolesByNum(String num) {
        // TODO Auto-generated method stub
        return (List<String>) getCurrentSession()
                .createQuery("select roles from UserRoles where userNum='" + num + "'").list();
    }

    @Override
    @Transactional
    public void deleteRoles(User user) {
        getCurrentSession().createQuery("delete from UserRoles where userNum=" + user.getNum()).executeUpdate();
    }
}
