package com.ambow.second.dao;

import com.ambow.second.entity.Course;
import com.ambow.second.entity.Score;
import com.ambow.second.entity.User;
import com.ambow.second.vo.ScoreVo;

import java.util.List;

public interface IScoreDao extends ICommonDao<Score> {


    List<ScoreVo> getScoreByuserId(String userId);

    List<ScoreVo> getScoreByteacherId(String teacherid, int index);

    List<ScoreVo> getScoreByadminId(int index);

    String saveBefor( String userId,String courseId);

    List<User> getAllUser();

    List<Course> getAllCourse();

    List<ScoreVo> getScoredBylike(String like);

    List<ScoreVo> getScoredByteacherike(String tescherId,String like);

    long countScoreVo();

    long countScoreVoByteacher(String teacherId);


}
