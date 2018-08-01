package com.ambow.second.service.impl;

import com.ambow.second.dao.IScoreDao;
import com.ambow.second.entity.Score;
import com.ambow.second.service.IScoreService;
import com.ambow.second.vo.ScoreVo;
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
    public List<ScoreVo> getScore(String id) {

        return scoreDao.getScore(id);
    }


}
