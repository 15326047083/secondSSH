package com.ambow.second.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.ambow.second.dao.IUserDao;
import com.ambow.second.dao.impl.UserDao;
import com.ambow.second.service.IUserService;
import com.ambow.second.service.impl.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/user")
public class UserAction extends ActionSupport {

    @Autowired
    private IUserService userService;

    @Action(value = "Welcome", results = {@Result(name = "success", location = "/WEB-INF/page/index.jsp")})
    public String execute() {
            System.out.println(111111);
            System.out.println();
            System.out.println(userService.queryAll().toString());
            return SUCCESS;
    }
}
