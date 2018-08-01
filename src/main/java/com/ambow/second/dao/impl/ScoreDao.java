package com.ambow.second.dao.impl;

import com.ambow.second.dao.IScoreDao;
import com.ambow.second.entity.Score;
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


    @Override
    @Transactional
    public List<ScoreVo> getScore(String userId) {

        return sessionFactory.getCurrentSession().createQuery("select new com.ambow.second.vo.ScoreVo(c.id as courseId,c.name as courseName,u.id as teacherId,u.name as teacherName,s.id as scoreId,s.score as score,c.lessons as courseLessons  ) from Score s,User u,Course c  " +
                "where s.userId=u.id and s.courseId=c.id and u.id='" + userId + "'").list();
    }
}