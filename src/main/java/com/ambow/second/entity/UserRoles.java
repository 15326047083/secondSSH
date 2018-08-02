package com.ambow.second.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 角色表
 */
@Entity
@Table(name = "roles")
public class UserRoles {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    //用户的学号
    @Column(name = "userNum")
    private String userNum;
    //角色名
    @Column(name = "roles")
    private String roles;

    public UserRoles() {

    }

    public UserRoles(String userNum, String roles) {
        this.userNum = userNum;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "id='" + id + '\'' +
                ", userNum='" + userNum + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}