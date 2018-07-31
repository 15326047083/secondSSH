package com.ambow.second.vo;

public class CheckVo {
    private String id; // 主键
    private String userId; // 用户ID
    private String UserName; // 姓名
    private int num; // 工号
    private String deptId; // 部门ID
    private String time; // 考勤时间
    private String courseId; // 课程ID
    private String courseName; // 课程名
    private String info; // 考勤详情
    private int absNum; // 缺勤次数


    public CheckVo() {
    }

    public CheckVo(String id, String userId, String userName, int num, String deptId, String time, String courseId, String courseName, String info, int absNum) {
        this.id = id;
        this.userId = userId;
        UserName = userName;
        this.num = num;
        this.deptId = deptId;
        this.time = time;
        this.courseId = courseId;
        this.courseName = courseName;
        this.info = info;
        this.absNum = absNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", UserName='" + UserName + '\'' +
                ", num=" + num +
                ", deptId='" + deptId + '\'' +
                ", time='" + time + '\'' +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", info='" + info + '\'' +
                ", absNum=" + absNum +
                '}';
    }
}
