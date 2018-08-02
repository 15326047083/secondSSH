package com.ambow.second.action;

import com.ambow.second.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

@Namespace("/login")
public class LoginAction {

    private User user; // 用户详情（内含用户前台输入工号以及密码）

    /**
     * 跳转方法
     *
     * @return 跳转至登录页面
     */
    @Action(value = "toLogin", results = {
            // 跳转至登录页面
            @Result(name = "success", location = "/WEB-INF/page/login/login.jsp")
    })
    public String toLogin() {
        return SUCCESS;
    }

    /**
     * 用户登录
     *
     * @return 对应页面
     */
    @Action(value = "login", results = {
            // 认证成功重定向至主页
            @Result(name = "success", location = "/course/queryCourse.action", type = "redirect"),
            // 认证失败重定向到登录界面
            @Result(name = "error", location = "/user/queryAll.action", type = "redirect")
    })
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getNum() + "", user.getPassword());
        try {
            subject.login(token);
        } catch (Exception e) {
            return ERROR;
        }
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
