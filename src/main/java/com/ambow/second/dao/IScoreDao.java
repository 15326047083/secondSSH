package com.ambow.second.dao;

import com.ambow.second.entity.Score;
import com.ambow.second.entity.User;

public interface IScoreDao extends ICommonDao<Score> {

    String saveScore(Score score);


}
