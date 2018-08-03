package com.ambow.second.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 用户
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id; // 主键
    @Column(name = "name")
    private String name; // 姓名
    @Column(name = "num")
    private int num; // 工号
    @Column(name = "phone")
    private String phone; // 手机号
    @Column(name = "email")
    private String email; // 邮箱
    @Column(name = "sex")
    private String sex; // 性别
    @Column(name = "edu")
    private String edu; // 学历
    @Column(name = "joinTime")
    private String joinTime; // 注册时间
    @Column(name = "deptId")
    private String deptId; // 部门ID
    @Column(name = "duty")
    private String duty; // 职务
    @Column(name = "userType")
    private String userType; // 用户类型
    @Column(name = "password")
    private String password; // 用户密码
    @Column(name = "alive")
    private int alive; // 用户状态（0为正常 1为注销）

    public User() {

    }

    public User(String id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    public User(String name, int num, String phone, String email, String sex, String edu, String joinTime, String
            deptId,
                String duty, String userType, String password, int alive) {
        this.name = name;
        this.num = num;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.edu = edu;
        this.joinTime = joinTime;
        this.deptId = deptId;
        this.duty = duty;
        this.userType = userType;
        this.password = password;
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", edu='" + edu + '\'' +
                ", joinTime='" + joinTime + '\'' +
                ", deptId='" + deptId + '\'' +
                ", duty='" + duty + '\'' +
                ", userType='" + userType + '\'' +
                ", password='" + password + '\'' +
                ", alive=" + alive +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAlive() {
        return alive;
    }

    public void setAlive(int alive) {
        this.alive = alive;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}