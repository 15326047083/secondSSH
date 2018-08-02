package com.ambow.second.action;

import com.ambow.second.entity.Check;
import com.ambow.second.entity.Course;
import com.ambow.second.entity.User;
import com.ambow.second.service.ICheckService;
import com.ambow.second.service.ICourseService;
import com.ambow.second.service.IUserService;
import com.ambow.second.vo.CheckVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Namespace("/check")
public class CheckAction extends ActionSupport {

    @Autowired
    private ICheckService iCheckService;
    @Autowired
    private ICourseService iCourseService;
    @Autowired
    private IUserService iUserService;
    private List<CheckVo> list;

    private String userId;
    private String courseId;
    private int num;
    private String info;
    private String id;
    private String bj;




    /**
     * 全部考勤列表信息（管理员）
     *
     * @return
     */
    @Action(value = "toCheckList", results = {@Result(name = "success", location = "/WEB-INF/page/check/checkList" +
            ".jsp", type = "dispatcher")})
    public String toCheckList() {
        list = iCheckService.queryCheckVoAll();
        ActionContext.getContext().put("list", list);
      //  ActionContext.getContext().put("role", "admin");
        return SUCCESS;
    }

    /**
     * 全部考勤列表信息（教师）
     *
     * @return
     */
    @Action(value = "toListByTeacherId", results = {@Result(name = "success", location =
            "/WEB-INF/page/check/checkList.jsp")})
    public String toListByTeacherId() {

        /* 添加一个teacherID
           从session 中获得userId 即为 teacherID
         */
        String teacherId = "1";
        list = iCheckService.queryCheskVoAllByTeacherId(teacherId);
        ActionContext.getContext().put("list", list);
       // ActionContext.getContext().put("role", "teacher");

        return SUCCESS;
    }

    /**
     * 全部考勤列表信息（自己）
     *
     * @return
     */
    @Action(value = "toListByUserId", results = {@Result(name = "success", location = "/WEB-INF/page/check/checkList" +
            ".jsp")})
    public String toListByUserId() {

        /*
           从session 中获得userId
         */
        String userId = "1";
        list = iCheckService.getByCheckVoId(userId);
        ActionContext.getContext().put("list", list);
    //    ActionContext.getContext().put("role", "user");
        return SUCCESS;
    }

    /**
     * 跳转到新增考勤（管理员）
     * 将用户列表与课程列表传入页面
     * @return
     */
    @Action(value = "toNewCheck", results = {@Result(name = "success", location = "/WEB-INF/page/check/newCheck.jsp")})
    public String toNewCheck() {
        List<User> userList=iUserService.queryAll();
        List<Course> courseList=iCourseService.queryCourse();
        ActionContext.getContext().put("userList",userList);
        ActionContext.getContext().put("courseList",courseList);
        return SUCCESS;
    }

    /**
     * 跳转到新增考勤（教师）
     * 将用户列表与课程列表传入页面
     * @return
     */
    @Action(value = "toNewCheckOfTeacher", results = {@Result(name = "success", location = "/WEB-INF/page/check/newCheck.jsp")})
    public String toNewCheckOfTeacher() {
        // 获取教师ID
        // role
        String teacherId="1";
        List<User> userList=iUserService.queryAll();
        List<Course> courseList=iCourseService.queryTeacherById(teacherId);
        ActionContext.getContext().put("userList",userList);
        ActionContext.getContext().put("courseList",courseList);
        return SUCCESS;
    }

    /**
     * 新增考勤列表
     * @return
     */
    @Action(value = "newCheck", results = {@Result(name = "teacher", location = "/toListByTeacherId.action",type = "redirect"),
            @Result(name = "admin",location = "toCheckList.action",type = "redirect")})
    public String newCheck(){
        Check check=new Check();
        check.setCourseId(this.courseId);
        check.setInfo(this.info);
        check.setNum(this.num);
        check.setUserId(this.userId);


        Check check1=iCheckService.sava(check);
      //  如果找不到相同信息，即同一个人的同一个课程
        if (check1==null){
            iCheckService.setAbsNum(check);
        }
        //如果存在则修改缺勤次数
        else{
            int num1=check1.getNum();
            check1.setNum(num1+check.getNum());
            check1.setInfo(check.getInfo());
            iCheckService.setAbsNum(check1);
        }

        // 获取角色 role
        // bj = role;
        // return "bj";
        return "admin";
    }

    /**
     * 修改考勤信息
     * @return
     */
    @Action(value = "updateCheck", results = {@Result(name = "teacher", location = "/toListByTeacherId.action",type = "redirect"),
            @Result(name = "admin",location = "toCheckList.action",type = "redirect")})
    public String updateCheck(){
        Check check=iCheckService.get(id);
        check.setNum(this.num);
        iCheckService.setAbsNum(check);
        // 获取角色 role
        // bj = role;
        // return "bj";
        return "admin";

    }

    /**
     * 跳转到 修改考勤 列表
     * @return
     */
    @Action(value = "toUpdateCheck",results = {@Result(name = "success",location = "/WEB-INF/page/check/updateCheck.jsp")})
    public String toUpdateCheck(){
        System.out.println(id);
        CheckVo checkVo=iCheckService.getById(id);
        ActionContext.getContext().put("checkVo",checkVo);
        return  SUCCESS;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
