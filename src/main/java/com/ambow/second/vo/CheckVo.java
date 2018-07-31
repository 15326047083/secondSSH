package com.ambow.second.vo;

import javax.persistence.Entity;

public class CheckVo {
    private String checkId; // 主键
    private String userId; // 用户ID
    private String userName; // 姓名
    private int num; // 工号
    private String deptName; // 部门名称
    private String time; // 考勤时间
    private String courseId; // 课程ID
    private String courseName; // 课程名
    private String info; // 考勤详情
    private int absNum; // 缺勤次数

    public CheckVo(){

    }
    public CheckVo(String checkId, String userId, String userName, int num, String deptName, String time, String courseId, String courseName, String info, int absNum) {
        this.checkId = checkId;
        this.userId = userId;
        this.userName = userName;
        this.num = num;
        this.deptName = deptName;
        this.time = time;
        this.courseId = courseId;
        this.courseName = courseName;
        this.info = info;
        this.absNum = absNum;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getAbsNum() {
        return absNum;
    }

    public void setAbsNum(int absNum) {
        this.absNum = absNum;
    }

    @Override
    public String toString() {
        return "CheckVo{" +
                "checkId='" + checkId + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", num=" + num +
                ", deptName='" + deptName + '\'' +
                ", time='" + time + '\'' +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", info='" + info + '\'' +
                ", absNum=" + absNum +
                '}';
    }
}
