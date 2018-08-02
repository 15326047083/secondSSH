package com.ambow.second.service;

import com.ambow.second.entity.Score;
import com.ambow.second.vo.ScoreVo;

import java.util.List;

public interface IScoreService {
    String saveorUpdateScore(Score score);
    ScoreVo getScoreById(String id);
    void deleteScore(String id);
    List<Score>  getAll();
    List<ScoreVo> getScoreByuserId(String id);
    List<ScoreVo> getScoreBycourseName(String couserName);


    Score get(String id);
}
