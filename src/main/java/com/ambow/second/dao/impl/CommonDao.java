package com.ambow.second.dao.impl;

import com.ambow.second.dao.ICommonDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public class CommonDao<T> implements ICommonDao<T> {

    Class<T> entity;
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    private Session getCurrentSession() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        entity = (Class<T>) pt.getActualTypeArguments()[0];
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public String saveOrUpdate(T t) {
        return null;
    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public T getById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<T> queryAll() {
        return getCurrentSession().createQuery("from " + entity.getSimpleName()).list();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<T> queryAll(String sql) {
        return null;
    }

    @Override
    public T getByConditions(String sql) {
        return null;
    }
}
