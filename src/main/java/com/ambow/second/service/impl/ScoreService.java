package com.ambow.second.service.impl;

import com.ambow.second.dao.IScoreDao;
import com.ambow.second.entity.Score;
import com.ambow.second.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService implements IScoreService {

    @Autowired
    private IScoreDao scoreDao;


    @Override
    public  void NewScoreService(Score score){

        scoreDao.saveOrUpdate(score);
    }

}
