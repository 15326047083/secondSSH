package com.ambow.second.service;

import com.ambow.second.entity.Course;

import java.util.List;

public interface ICourseService {
    //增加课程信息
    void addCourse(Course course);
    //根据teacherID查询课程信息
    List<Course> queryTeacherById(String teacherId);
    //查询全部课程信息
    List<Course> queryCourse();
    //修改课程状态 alive 0为正常 1为注销
    void updateCourse(Course course);
    //根据ID删除课程信息
    void deleteCourse(String id);

    Course getById(String courseId);
    //

}
