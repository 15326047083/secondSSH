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

        if(scoreDao.savebefor(score.getUserId(),score.getCourseId())==null) {
            scoreDao.saveOrUpdate(score);
        }
        return "";
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
    public List<ScoreVo> getScoreByuserId(String id,int index) {

        return scoreDao.getScoreByuserId(id,index);
    }

    /**
     * 根据教书Id查询成绩
     * @param teacherid
     * @param index
     * @return
     */

    @Override
    public List<ScoreVo> getScoreByteacherId(String teacherid,int index) {
        return scoreDao.getScoreByteacherId(teacherid,index);
    }


    /**
     * 管理员查询全部成绩
     */

    @Override
    public List<ScoreVo> getScoreByadminId(int index) {
        return scoreDao.getScoreByadminId(index);
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
     * 查询全部用户和全部课程
     */

public  List<User> getAllUser(){
    return  scoreDao.getAllUser();
}

    @Override
    public List<Course> getAllCourse() {
        return scoreDao.getAllCourse();
    }

    /**
     * 模糊查询
     * @param like
     * @return
     */
    @Override
    public List<ScoreVo> getScoredBylike(String like) {

    return scoreDao.getScoredBylike(like);
    }

    /**
     * 统计查询个数
     * @return
     */
    @Override
    public long countScoreVo() {
        return scoreDao.countScoreVo();
    }

}
