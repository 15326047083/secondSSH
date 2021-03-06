package com.ambow.second.dao.impl;

import com.ambow.second.dao.ICourseDao;
import com.ambow.second.entity.Course;
import com.ambow.second.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseDao extends CommonDao<Course> implements ICourseDao {
    @Autowired
    private SessionFactory sessionFactory;

    final int num=10;        // 一页显示的数目

    @Override
    @Transactional
    /**
     * 根据teacherID查询课程信息
     */
    public List<Course> queryTeacherById(String teacherId) {


        return sessionFactory.getCurrentSession().createQuery("from Course where teacherId='" + teacherId + "'").list();
    }

    /**
     * 根据用户的工号获取用户信息
     *
     * @param teacherNum 用户工号
     * @return 用户信息
     */
    @Override
    @Transactional
    public User getUserByNum(int teacherNum) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where num=" + teacherNum).uniqueResult();
    }
    /**
     * 查询用户表信息
     */
    @Override
    @Transactional
    public List<User> queryUser() {

        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }
    /**
     * 分页查询
     *
     */
    @Override
    @Transactional
    public long countVo() {
        String sql="select count(*) from Course ";
        return (long) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();


    }

    /**
     *查询全部课程
     * @return
     */
    @Override
    @Transactional
    public List<Course> getAll(int index) {
        String sql="from Course";
        Query query=sessionFactory.getCurrentSession().createQuery(sql);
        query.setFirstResult((index-1)*num);
        query.setMaxResults(num);
        return query.list();
    }


}
