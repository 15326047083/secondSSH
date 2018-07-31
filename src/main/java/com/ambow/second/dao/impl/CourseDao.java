package com.ambow.second.dao.impl;

import com.ambow.second.dao.ICourseDao;
import com.ambow.second.entity.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseDao extends CommonDao<Course> implements ICourseDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    //根据教师ID 查询自己所教授的课程
    public List<Course> queryTeacherById(String teacherId) {
        return sessionFactory.getCurrentSession().createQuery("from Course where teacherId='"+teacherId+"'").list();
    }









}
