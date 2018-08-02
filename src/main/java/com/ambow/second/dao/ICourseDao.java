package com.ambow.second.dao;

import com.ambow.second.entity.Course;
import com.ambow.second.entity.User;


import java.util.List;

public interface ICourseDao extends ICommonDao<Course> {

    // 根据teacherID查询课程信息
    List<Course> queryTeacherById(String teacherId) ;

    // 根据工号查询该教师所教授的课程
    User getUserByNum(int teacherNum);
    //查询用户表
    List<User> queryUser();
}
