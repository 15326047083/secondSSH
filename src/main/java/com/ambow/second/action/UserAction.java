package com.ambow.second.action;

import com.ambow.second.entity.User;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.ambow.second.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/user")
public class UserAction extends ActionSupport {
    @Autowired
    private IUserService userService;
    private User user;
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    private String userId;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Action(value = "queryAll", results = {@Result(name = "success", location = "/WEB-INF/page/user/list.jsp")})
    public String queryAll(){
        ActionContext actionContext=ActionContext.getContext();
        actionContext.put("queryAllList",userService.queryAll());
        return SUCCESS;
    }
    @Action(value ="" ,results = { @Result(name = "success", location = "/WEB-INF/page/user/list.jsp")})
    public String delete(){

        return SUCCESS;
    }
    @Action (value = "toUpdate", results = {@Result(name = "success" , location = "/WEB-INF/page/user/saveOrUpdate.jsp")},params = {"userId","%{userId}"})
    public String toUpdate(){
        User user=new User();
        user.setId(userId);
        ActionContext.getContext().put("userInfo", userService.findUserById(user));
        return SUCCESS;
    }
    @Action (value = "update", results = {@Result(name = "success" , location = "/user/queryAll.action",type = "redirect")})
    public String update(){
        userService.saveOrUpdate(user);
        return SUCCESS;
    }
}
