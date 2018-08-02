package com.ambow.second.dao.impl;

import com.ambow.second.dao.IUserPermissionsDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserPermissionsDao implements IUserPermissionsDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<String> getByRoles(String roles) {
        // TODO Auto-generated method stub
        return (List<String>) getCurrentSession().createQuery("select permissions from UserPermissions where roles = '" + roles + "'").list();
    }
}
