package com.ambow.second.service;

import com.ambow.second.entity.Course;

import java.util.List;

public interface ICourseService {
    void addCourse(Course course);
    List<Course> queryTeacherById(String teacherId);
    List<Course> queryCourse();
    void updateCourse(Course course);
}
