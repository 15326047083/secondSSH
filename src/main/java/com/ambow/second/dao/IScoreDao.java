package com.ambow.second.dao;

import com.ambow.second.entity.Score;
import com.ambow.second.entity.User;

import java.util.List;

public interface IScoreDao extends ICommonDao<Score> {


    List<Score> getScoreByuserId(String userId);
    List<Score> getScoreByCourseId(String courseId);
}
