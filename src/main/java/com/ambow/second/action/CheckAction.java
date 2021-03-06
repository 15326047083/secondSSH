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
import org.apache.shiro.SecurityUtils;
import org.apache.struts2.ServletActionContext;
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

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    private String str;//接受到的模糊查询字段

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int index;  //当前页数


    /**
     * 全部考勤列表信息（管理员/教师）
     *
     * @return
     */
    @Action(value = "toCheckList", results = {@Result(name = "success", location = "/WEB-INF/page/check/checkList" +
            ".jsp", type = "dispatcher")})
    public String toCheckList() {
//        权限
//        教师查询
        long page=0;
        if (SecurityUtils.getSubject().hasRole("admin")) {
            list = iCheckService.queryCheckVoAll(index);
            page=iCheckService.countVo();
        }
        else if (SecurityUtils.getSubject().hasRole("teacher")) {
            User user = (User) ServletActionContext.getRequest().getSession().getAttribute("userSession");
            list = iCheckService.queryCheskVoAllByTeacherId(user.getId(), index);
            page=iCheckService.countVoOfTeacher(user.getId());
        }

        if (index==0){
            index=Integer.parseInt(String.valueOf(page))/10+1;
            if (index==0){
                index=1;
            }

        }

        tag(page);
        ActionContext.getContext().put("list", list);
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
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("userSession");
        String userId = user.getId();
        list = iCheckService.getByCheckVoId(userId);
        ActionContext.getContext().put("list", list);
        ActionContext.getContext().put("role", "user");

        return SUCCESS;
    }

    /**
     * 跳转到新增考勤（管理员）
     * 将用户列表与课程列表传入页面
     *
     * @return
     */
    @Action(value = "toNewCheck", results = {@Result(name = "success", location = "/WEB-INF/page/check/newCheck.jsp")})
    public String toNewCheck() {
//
//        教师添加（）
//        String teacherId="1";
//        List<Course>

        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("userSession");
        List<Course> courseList = null;

        if (SecurityUtils.getSubject().hasRole("admin")) {
            courseList = iCourseService.queryCourse();
        }
        else if (SecurityUtils.getSubject().hasRole("teacher")) {
            courseList = iCourseService.queryTeacherById(user.getId());
        }
        List<User> userList = iUserService.queryAll();
        ActionContext.getContext().put("userList", userList);
        ActionContext.getContext().put("courseList", courseList);
        return SUCCESS;
    }

    /**
     * 新增考勤列表
     *
     * @return
     */
    @Action(value = "newCheck", results = {@Result(name = "success", location = "toCheckList.action", type =
            "redirect")})
    public String newCheck() {
        Check check = new Check();
        check.setCourseId(this.courseId);
        check.setInfo(this.info);
        check.setNum(this.num);
        check.setUserId(this.userId);
        Check check1 = iCheckService.sava(check);
        //  如果找不到相同信息，即同一个人的同一个课程
        if (check1 == null) {
            iCheckService.setAbsNum(check);
        }
        //如果存在则修改缺勤次数
        else {
            int num1 = check1.getNum();
            check1.setNum(num1 + check.getNum());
            check1.setInfo(check.getInfo());
            iCheckService.setAbsNum(check1);
        }

        ActionContext.getContext().put("index", 1);
        return SUCCESS;
    }

    /**
     * 修改考勤信息
     *
     * @return
     */
    @Action(value = "updateCheck", results = {@Result(name = "success", location = "toCheckList.action", type =
            "redirect")})
    public String updateCheck() {
        Check check = iCheckService.get(id);
        check.setNum(this.num);
        iCheckService.setAbsNum(check);
        // 获取角色 role
        // bj = role;
        // return "bj";
        ActionContext.getContext().put("index", 1);
        return SUCCESS;

    }

    /**
     * 跳转到 修改考勤 列表
     *
     * @return
     */
    @Action(value = "toUpdateCheck", results = {@Result(name = "success", location = "/WEB-INF/page/check/updateCheck" +
            ".jsp")})
    public String toUpdateCheck() {
        //  System.out.println(id);
        CheckVo checkVo = iCheckService.getById(id);
        ActionContext.getContext().put("checkVo", checkVo);
        return SUCCESS;
    }

    /**
     * 模糊查询
     *
     * @return
     */
    @Action(value = "fuzzyQuery", results = {@Result(name = "success", location = "/WEB-INF/page/check/checkList" +
            ".jsp"), @Result(name = "listAll", location = "toCheckList.action", type =
            "redirect")})
    public String fuzzyQuery() {

        if ("".equals(str)) {
            ActionContext.getContext().put("index",1);
            return "listAll";
        }
       else {

            long page = 0;
            User user = (User) ServletActionContext.getRequest().getSession().getAttribute("userSession");

            if (SecurityUtils.getSubject().hasRole("admin")) {

                page = iCheckService.fuzzyCountVo(str);
                list = iCheckService.fuzzyQuery(str, index);
            } else if (SecurityUtils.getSubject().hasRole("teacher")) {
                page = iCheckService.fuzzyCountVoOfTeacher(str, user.getId());
                list = iCheckService.fuzzyQueryOfTeacher(str, user.getId(), index);
            }
            System.out.println(page);
            tag(page);

            ActionContext.getContext().put("list", list);
            ActionContext.getContext().put("index", index);
            ActionContext.getContext().put("bj", "fuzzy");
            ActionContext.getContext().put("str", str);

            return SUCCESS;
        }
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


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
