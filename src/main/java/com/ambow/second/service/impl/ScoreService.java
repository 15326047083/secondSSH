package com.ambow.second.service.impl;

import com.ambow.second.dao.IScoreDao;
import com.ambow.second.entity.Score;
import com.ambow.second.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService implements IScoreService {

    @Autowired
    private IScoreDao scoreDao;


    @Override
    public String saveorUpdateScore(Score score) {

        return  scoreDao.saveOrUpdate(score);
    }

    @Override
    public Score getScoreById(String id) {
        return scoreDao.get(id);
    }

    @Override
    public void deleteScore(String id) {
        scoreDao.delete(id);
    }

    @Override
    public List<Score> getAll() {

        return scoreDao.queryAll();
    }

    @Override
    public List<Score> getScoreByuserId(String id) {

        System.out.print(id);
        return scoreDao.getScoreByuserId(id);
    }

    @Override
    public List<Score> getScoreByCouserId(String id) {


        return scoreDao.getScoreByCourseId(id);
    }


}
