package com.ambow.second.dao;

import com.ambow.second.entity.Course;


import java.util.List;

public interface ICourseDao extends ICommonDao<Course> {

         // 根据teacherID查询课程信息

        List<Course> queryTeacherById(String teacherId) ;

}
