package com.ambow.second.action;

import com.ambow.second.entity.User;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.ambow.second.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

import javax.management.Query;
import java.util.Date;

@Namespace("/user")
public class UserAction extends ActionSupport {
    @Autowired
    //  注入userService
    private IUserService userService;
    //  封装user对象
    private User user;
    //  封装userId对象
    private String userId;
    //  封装selectKey对象
    private String selectKey;

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSelectKey() { return selectKey; }
    public void setSelectKey(String selectKey) { this.selectKey = selectKey; }
    /**
     * 查询所有用户
     * @return
     */
    @Action(value = "queryAll", results = {@Result(name = "success", location = "/WEB-INF/page/user/list.jsp")})
    public String queryAll(){

        userService.queryAll();
        ActionContext actionContext=ActionContext.getContext();
        actionContext.put("queryAllList",userService.queryAll());
        return SUCCESS;
    }
    /**
     *  前往新增页面
     * @return
     */
    @Action(value ="toAddUser" ,results = { @Result(name = "success", location = "/WEB-INF/page/user/addUser.jsp")})
    public String toAddUser(){
        return SUCCESS;
    }
    /**
     *  新增用户
     * @return
     */
    @Action(value ="addUser" ,results = { @Result(name = "success", location = "/user/queryAll.action",type = "redirect")})
    public String addUser(){
        user.setJoinTime(new Date().toString());
        user.setAlive(0);
        userService.saveOrUpdate(user);
        System.out.println(user.getSex()+"<><><><><><><><><>");
        return SUCCESS;
    }
    /**
     *  前往修改页面
     * @return
     */
    @Action (value = "toUpdate", results = {@Result(name = "success" , location = "/WEB-INF/page/user/saveOrUpdate.jsp")},params = {"userId","%{userId}"})
    public String toUpdate(){
        User user=new User();
        user.setId(userId);
        ActionContext.getContext().put("userInfo", userService.findUserById(user));
        return SUCCESS;
    }
    /**
     *  修改用户信息
     * @return
     */
    @Action (value = "update", results = {@Result(name = "success" , location = "/user/queryAll.action",type = "redirect")})
    public String update(){
        userService.saveOrUpdate(user);
        return SUCCESS;
    }
    /**
     * 删除用户
     * @return
     */
    @Action (value = "updateAlive" ,results = {@Result(name = "success", location = "/user/queryAll.action",type = "redirect")},params = {"userId","%{userId}"})
    public String updateAlive(){
        User u=new User();
        u.setId(userId);
        User user=userService.findUserById(u);
        user.setAlive(1);
        userService.updateAlive(user);
        return SUCCESS;
    }
    /**
     *  模糊查询
     * @return
     */
    @Action (value = "likeSelect" ,results = {@Result(name = "success", location = "/WEB-INF/page/user/list.jsp")})
    public String likeSelect(){
        ActionContext actionContext=ActionContext.getContext();
        actionContext.put("queryAllList",userService.likeSelect(selectKey));
        return SUCCESS;
    }
}
