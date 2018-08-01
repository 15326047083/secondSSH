package com.ambow.second.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 考勤
 */
@Entity
@Table(name = "clocking")
public class Check {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id; // 主键
    @Column(name = "userId")
    private String userId; // 用户工号
    @Column(name = "time")
    private String time; // 考勤时间
    @Column(name = "courseId")
    private String courseId; // 课程ID
    @Column(name = "info")
    private String info; // 考勤详情
    @Column(name = "num")
    private int num; // 缺勤次数

    public Check() {

    }

    public Check(String userId, String time, String courseId, String info, int num) {
        this.userId = userId;
        this.time = time;
        this.courseId = courseId;
        this.info = info;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", time='" + time + '\'' +
                ", courseId='" + courseId + '\'' +
                ", info='" + info + '\'' +
                ", num=" + num +
                '}';
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
}
