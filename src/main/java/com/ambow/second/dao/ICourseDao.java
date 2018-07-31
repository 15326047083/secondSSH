package com.ambow.second.dao;

import com.ambow.second.entity.Course;


import java.util.List;

public interface ICourseDao extends ICommonDao<Course> {
   
        List<Course> queryTeacherById(String teacherId) ;

}
