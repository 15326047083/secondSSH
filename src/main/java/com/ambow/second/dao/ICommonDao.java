package com.ambow.second.dao;

import java.util.List;

public interface ICommonDao<T> {
    String saveOrUpdate(T t);

    T get();

    T getById(String id);

    void delete(String id);

    List<T> queryAll();

    long count();

    List<T> queryAll(String sql);

    T getByConditions(String sql);
}
