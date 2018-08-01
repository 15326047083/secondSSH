package com.ambow.second.action;

import com.ambow.second.entity.Course;
import com.ambow.second.service.ICourseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

@Namespace("/course")
public class CourseAction extends ActionSupport {
    @Autowired
    private ICourseService courseService;
    private Course course;
private String courseId;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * 添加课程信息
     * @return
     */

    @Action(value = "saveCourse", results = {@Result(name = "success", location = "queryCourse.action",type = "redirect")})
    public String saveCourse(){

        courseService.addCourse(course);
          return SUCCESS;
         }
    @Action(value = "toNew", results = {@Result(name = "success", location = "/WEB-INF/page/course/new.jsp")})
    public String toNew(){
        return SUCCESS;
         }
    /**
     *查询全部课程信息
      * @return
     */
    @Action(value = "queryCourse", results = {@Result(name = "success", location = "/WEB-INF/page/course/list.jsp")})
    public String queryCourse(){
        ActionContext actionContext=ActionContext.getContext();
        actionContext.put("courseList",courseService.queryCourse());
        return SUCCESS;
         }

    /**
     * 根据id删除课程信息
      * @return
     */
    @Action(value = "deleteCourse", results = {@Result(name = "success", location = "queryCourse.action",type = "redirect")},params = {"courseId","%{courseId}"})
     public String deleteCourse(){

       courseService.deleteCourse(this.courseId);
        return SUCCESS;
     }

    /**
     * 修改课程状态
     */
    @Action(value = "updateCourse", results = {@Result(name = "success", location = "queryCourse.action",type = "redirect")},params = {"courseId","%{courseId}"})
    public String updateCourse(){
        Course course=courseService.getById(courseId);
        course.setAlive(1);
        courseService.updateCourse(course);
        return SUCCESS;
    }
    /**
     * 根据teacherId
     */


}
