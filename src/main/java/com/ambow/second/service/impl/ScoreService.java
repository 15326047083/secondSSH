package com.ambow.second.service.impl;

import com.ambow.second.dao.IScoreDao;
import com.ambow.second.entity.Course;
import com.ambow.second.entity.Score;
import com.ambow.second.entity.User;
import com.ambow.second.service.IScoreService;
import com.ambow.second.vo.ScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService implements IScoreService {

    @Autowired
    private IScoreDao scoreDao;


    /**
     * 保存/修改成绩
     * @param score
     * @return
     */
    @Override
    public String saveorUpdateScore(Score score) {

        return  scoreDao.saveOrUpdate(score);
    }


    /**
     * 删除成绩
     * @param id
     */

    @Override
    public void deleteScore(String id) {
        scoreDao.delete(id);
    }

    /**
     * 查询全部成绩
     * @return
     */

    @Override
    public List<Score> getAll() {

        return scoreDao.queryAll();
    }

    /**
     * 根据用户ID查询成绩
     * @param id
     * @return
     */

    @Override
    public List<ScoreVo> getScoreByuserId(String id) {

        return scoreDao.getScoreByuserId(id);
    }


    /**
     * 根据成绩ID查询成绩
     * @param id
     * @return
     */

    @Override
    public Score get(String id) {
        return scoreDao.get(id);
    }

    /**
     * 查询全部用户
     */

public  List<User> getAllUser(){
    return  scoreDao.getAllUser();
}

    @Override
    public List<Course> getAllCourse() {
        return scoreDao.getAllCourse();
    }

    @Override
    public List<ScoreVo> getScoredBylike(String like) {

    return scoreDao.getScoredBylike(like);
    }

}
