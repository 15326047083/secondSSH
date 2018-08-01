package com.ambow.second.dao.impl;

import com.ambow.second.dao.IScoreDao;
import com.ambow.second.entity.Score;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class ScoreDao extends CommonDao<Score> implements IScoreDao {
@Autowired
private SessionFactory  sessionFactory;


    @Override
    @Transactional
    public List<Score> getScoreByuserId(String userId) {

        return (List<Score>) sessionFactory.getCurrentSession().createQuery("from Score where userId='"+userId +"'").list();
    }

    @Override
    @Transactional
    public List<Score> getScoreByCourseId(String courseId) {

        return (List<Score>) sessionFactory.getCurrentSession().createQuery("from Score where courseId='"+courseId+"'").list();
    }
}
