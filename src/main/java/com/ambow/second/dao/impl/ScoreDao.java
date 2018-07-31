package com.ambow.second.dao.impl;

import com.ambow.second.dao.IScoreDao;
import com.ambow.second.entity.Score;
import org.springframework.stereotype.Repository;


@Repository
public class ScoreDao extends CommonDao<Score> implements IScoreDao {
}
