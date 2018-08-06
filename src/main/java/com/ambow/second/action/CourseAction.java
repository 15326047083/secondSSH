package com.ambow.second.action;

import com.ambow.second.entity.Course;
import com.ambow.second.entity.User;
import com.ambow.second.service.ICourseService;
import com.ambow.second.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Namespace("/course")
public class CourseAction extends ActionSupport {
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IUserService userService;
    private Course course;//定义course对象
    private String courseId;//定义courseId 删除对象
    private String teacherId;
    private int teacherNum;//查询该教师所教授的所有课程
    private int Num;
    private int index;  //当前页数

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }


    public CourseAction() {
    }

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


    public int getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(int teacherNum) {
        this.teacherNum = teacherNum;
    }

    @Action(value = "getInfoByCourseIdAndTeacherId", results = {
            @Result(name = "success", location = "/WEB-INF/page/course/info.jsp")
    })
    public String getInfoByCourseIdAndTeacherId() {
        Course course = courseService.getById(courseId);
        User user = new User();
        user.setId(teacherId);
        User teacher = userService.findUserById(user);
        ActionContext.getContext().put("teacher", teacher);
        ActionContext.getContext().put("course", course);
        return SUCCESS;
    }

    /**
     * 添加课程信息
     *
     * @return
     */

    @Action(value = "saveCourse", results = {@Result(name = "success", location = "queryCourse.action", type =
            "redirect")})
    public String saveCourse() {

        ActionContext.getContext().put("index", index);
        courseService.addCourse(course);
        return SUCCESS;
    }

    /**
     * 前往增加页面的过程中
     * 获取User表的值
     *
     * @return
     */
    @Action(value = "toNew", results = {@Result(name = "success", location = "/WEB-INF/page/course/new.jsp")})
    public String toNew() {

        List<User> userList = courseService.getTeacherList();
        ActionContext.getContext().put("userList", userList);

        return SUCCESS;
    }

    /**
     * 查询全部课程信息
     *
     * @return
     */
//    @Action(value = "queryCourse", results = {@Result(name = "success", location = "/WEB-INF/page/course/list.jsp")})
//    public String queryCourse() {
//        ActionContext actionContext = ActionContext.getContext();
//        actionContext.put("courseList", courseService.queryCourse());
//        return SUCCESS;
//    }

    /**
     * 根据id删除课程信息
     *
     * @return
     */
    @Action(value = "deleteCourse", results = {@Result(name = "success", location = "queryCourse.action", type =
            "redirect")}, params = {"courseId", "%{courseId}"})
    public String deleteCourse() {
        ActionContext.getContext().put("index", 1);
        courseService.deleteCourse(this.courseId);
        return SUCCESS;
    }

    /**
     * 修改课程状态
     */
    @Action(value = "updateCourse", results = {@Result(name = "success", location = "queryCourse.action", type =
            "redirect")}, params = {"courseId", "%{courseId}"})
    public String updateCourse() {
        Course course = courseService.getById(courseId);
        course.setAlive(1);
        ActionContext.getContext().put("index", 1);
        courseService.updateCourse(course);
        return SUCCESS;
    }

    /**
     * 根据teacherId查询该老师所教授课程
     */
    @Action(value = "queryTeacherId", results = {@Result(name = "success", location = "/WEB-INF/page/course/list" +
            ".jsp"), @Result(name = "error", location = "queryCourse.action", type = "redirect")})
    public String queryTeacherId() {
        User teacher = courseService.getUserByNum(teacherNum);
        if (teacher != null) {
            List<Course> courseList = courseService.queryTeacherById(teacher.getId());
            ActionContext.getContext().put("courseList", courseList);

            ActionContext.getContext().put("index", 1);
            return SUCCESS;
        } else {
            ActionContext.getContext().put("index", 1);
            return ERROR;
        }
    }

    /**
     * 分页查询
     *
     * @return
     */

    @Action(value = "queryCourse", results = {@Result(name = "success", location = "/WEB-INF/page/course/list.jsp")})
    public String queryCourse() {
        ActionContext actionContext = ActionContext.getContext();

        long page = courseService.countVo();

        if (index==0){

            index=Integer.parseInt(String.valueOf(page));

            if (index%10==0){
                if (index/10==0){
                    index=1;
                }
            index=index/10;
            }else{
                index=index/10+1;
            }

        }
        tag(page);
        actionContext.put("courseList", courseService.getAll(index));
        ActionContext.getContext().put("index", index);
        return SUCCESS;
    }

    private void tag(long page) {
        if (page % 10 == 0) {
            if (page / 10 == 0) {
                page = 1;
                ActionContext.getContext().put("allPage", page);
            }
            ActionContext.getContext().put("allPage", page / 10);
        } else {
            ActionContext.getContext().put("allPage", page / 10 + 1);
        }
    }


    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}

