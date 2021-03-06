package com.ambow.second.service;

import com.ambow.second.entity.Course;
import com.ambow.second.entity.Score;
import com.ambow.second.entity.User;
import com.ambow.second.vo.ScoreVo;

import java.util.List;

public interface IScoreService {
    String saveorUpdateScore(Score score);

    void deleteScore(String id);

    List<Score> getAll();

    List<ScoreVo> getScoreByuserId(String id);

    List<ScoreVo> getScoreByteacherId(String teacherid,int index);

    List<ScoreVo> getScoreByadminId(int index);

    Score get(String id);

    List<User> getAllUser();

    List<Course> getAllCourse();

    List<ScoreVo> getScoredBylike(String like);

    List<ScoreVo> getScoredByteacherike(String  teacherId,String like);

    long countScoreVo();
    long countScoreVoByteacher(String teacherId);
}
