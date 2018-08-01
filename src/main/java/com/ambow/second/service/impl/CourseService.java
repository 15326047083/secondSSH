package com.ambow.second.service.impl;

import com.ambow.second.dao.ICourseDao;
import com.ambow.second.entity.Course;
import com.ambow.second.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseDao iCourseService;
    @Override
    public void addCourse(Course course) {

        iCourseService.saveOrUpdate(course);
    }

    @Override
    public List<Course> queryTeacherById(String teacherId) {
        return iCourseService.queryTeacherById(teacherId);

    }

    @Override
    public List<Course> queryCourse() {

        return iCourseService.queryAll();
    }

    @Override
    public void updateCourse(Course course) {
        iCourseService.saveOrUpdate(course);
    }

    @Override
    public void deleteCourse(String id) {
        iCourseService.delete(id);
    }

    @Override
    public Course getById(String courseId) {
        return iCourseService.get(courseId);
    }


}
