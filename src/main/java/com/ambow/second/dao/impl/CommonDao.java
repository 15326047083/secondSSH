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

    /**
     * 增加或修改
     *
     * @param t 实体类
     * @return 主键
     */
    @Override
    @Transactional
    public String saveOrUpdate(T t) {
        getCurrentSession().saveOrUpdate(t);
        return "";
    }

    /**
     * 根据ID获取信息
     *
     * @param id 实体类主键
     * @return 实体类信息（查询结果）
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public T get(String id) {
        return (T) getCurrentSession().createQuery("from " + entity.getSimpleName() + " where id='" + id + "'")
                .uniqueResult();
    }

    /**
     * 根据ID删除信息
     *
     * @param id 实体类主键
     */
    @Override
    @Transactional
    public void delete(String id) {
        // 获取实体类
        T t = get(id);
        // 执行hibernate删除方法
        getCurrentSession().delete(t);
    }

    /**
     * 获取列表
     *
     * @return 列表
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<T> queryAll() {
        return getCurrentSession().createQuery("from " + entity.getSimpleName()).list();
    }

    /**
     * 统计方法
     *
     * @return 数量
     */
    @Override
    public long count() {
        return 0;
    }

    /**
     * 根据传入sql 获取列表
     *
     * @param sql 传入的sql
     * @return 获取的列表信息
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<T> queryAll(String sql) {
        return getCurrentSession().createQuery(sql).list();
    }

    /**
     * 根据传入sql获取实体类
     *
     * @param sql 传入sql
     * @return 实体类信息
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public T getByConditions(String sql) {
        return (T) getCurrentSession().createQuery(sql).uniqueResult();
    }
}
