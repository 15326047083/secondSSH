package com.ambow.second.service.impl;

import com.ambow.second.dao.ICourseDao;
import com.ambow.second.dao.IUserDao;
import com.ambow.second.dao.IUserRolesDao;
import com.ambow.second.entity.Course;
import com.ambow.second.entity.User;
import com.ambow.second.entity.UserRoles;
import com.ambow.second.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseDao iCourseService;
    @Autowired
    private IUserRolesDao userRolesDao;
    @Autowired
    private IUserDao userDao;

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

    @Override
    public User getUserByNum(int teacherNum) {
        return iCourseService.getUserByNum(teacherNum);
    }

    @Override
    public List<User> queryUser() {
        return iCourseService.queryUser();
    }

    @Override
    public long countVo() {
        return iCourseService.countVo();
    }

    @Override
    public List<Course> getAll(int index) {
        return iCourseService.getAll(index);
    }

    @Override
    public List<User> getTeacherList() {
        String sql = "select new com.ambow.second.entity.User(u.id as id,u.name as name,u.num as num) from User u," +
                "UserRoles r where u.num=r.userNum and r.roles='teacher'";
        return userDao.queryAll(sql);
    }

}
