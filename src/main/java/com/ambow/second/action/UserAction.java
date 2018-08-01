package com.ambow.second.action;

import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.ambow.second.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/user")
public class UserAction extends ActionSupport {

    @Autowired
    private IUserService userService;

    @Action(value = "Welcome", results = {@Result(name = "success", location = "/head/index.jsp")})
    public String execute() {
            System.out.println(111111);
            System.out.println();
            System.out.println(userService.queryAll().toString());
            return SUCCESS;
    }
}
