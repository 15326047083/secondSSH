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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * 添加课程信息
     * @return
     */

    @Action(value = "saveCourse", results = {@Result(name = "success", location = "/WEB-INF/page/course/list.jsp")})
    public String saveCourse(){

        courseService.addCourse(course);
          return SUCCESS;
         }
    @Action(value = "toNew", results = {@Result(name = "success", location = "/WEB-INF/page/course/new.jsp")})
    public String toNew(){
        return SUCCESS;
         }
    /**
     *
      * @return
     */
    @Action(value = "queryCourse", results = {@Result(name = "success", location = "/WEB-INF/page/course/list.jsp")})
    public String queryCourse(){
        ActionContext actionContext=ActionContext.getContext();
        actionContext.put("courseList",courseService.queryCourse());
        return SUCCESS;
         }
}
