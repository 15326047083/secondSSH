package com.ambow.second.dao.impl;

import com.ambow.second.dao.ICourseDao;
import com.ambow.second.entity.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao extends CommonDao<Course> implements ICourseDao {
    @Autowired
    private SessionFactory sessionFactory;



}
