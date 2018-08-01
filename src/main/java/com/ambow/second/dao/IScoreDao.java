package com.ambow.second.dao;

import com.ambow.second.entity.Score;
import com.ambow.second.entity.User;
import com.ambow.second.vo.ScoreVo;

import java.util.List;

public interface IScoreDao extends ICommonDao<Score> {


  List<ScoreVo>  getScore(String userId);
}
