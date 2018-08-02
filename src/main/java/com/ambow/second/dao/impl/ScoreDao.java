package com.ambow.second.dao.impl;

import com.ambow.second.dao.IScoreDao;
import com.ambow.second.entity.Course;
import com.ambow.second.entity.Score;
import com.ambow.second.entity.User;
import com.ambow.second.vo.ScoreVo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class ScoreDao extends CommonDao<Score> implements IScoreDao {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 根据用户 ID查询成绩
     * @param userId
     * @return
     */

    @Override
    @Transactional
    public List<ScoreVo> getScoreByuserId(String userId) {

        return sessionFactory.getCurrentSession().createQuery("select new com.ambow.second.vo.ScoreVo(c.id as courseId,c.name as courseName,c.teacherId as teacherId,u.name as userName,s.id as scoreId,s.score as score,c.lessons as courseLessons  ) from Score s,User u,Course c  " +
                "where s.userId=u.id and s.courseId=c.id and u.id='" + userId + "'").list();
    }


    /**
     *
     * 根据教师Id查询成绩
     */
    @Override
    @Transactional
    public List<ScoreVo> getScoreByteacherId(String teacherid) {

        return sessionFactory.getCurrentSession().createQuery("select new com.ambow.second.vo.ScoreVo(c.id as courseId,c.name as courseName,c.teacherId as teacherId,u.name as userName,s.id as scoreId,s.score as score,c.lessons as courseLessons  ) from Score s,User u,Course c  " +
                "where s.userId=u.id and s.courseId=c.id and c.teacherId='" + teacherid + "'").list();
    }



    /**
     * 添加前查出全部课程名
     * @return
     */
    @Override
    @Transactional
    public List<User> getAllUser() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    @Transactional
    public List<Course> getAllCourse() {
        return sessionFactory.getCurrentSession().createQuery("from Course").list();
    }

    /**
     * 模糊查询
     */

    @Override
    @Transactional
    public List<ScoreVo> getScoredBylike(String like) {

        return sessionFactory.getCurrentSession().createQuery("select new com.ambow.second.vo.ScoreVo(c.id as courseId,c.name as courseName,u.id as teacherId,u.name as teacherName,s.id as scoreId,s.score as score,c.lessons as courseLessons  ) from Score s,User u,Course c  " +
                "where s.userId=u.id and s.courseId=c.id and (u.num like'%" + like + "%' or u.name like '%"+like+"%' or c.name like'%"+like+ "%')").list();
    }

}