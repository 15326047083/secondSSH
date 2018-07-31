package com.ambow.second.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 课程
 */
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id; // 主键
    @Column(name = "name")
    private String name; // 课程名
    @Column(name = "startTime")
    private String startTime; // 上课时间
    @Column(name = "endTime")
    private String endTime; // 下课时间
    @Column(name = "info")
    private String info; // 课程信息
    @Column(name = "teacherId")
    private String teacherId; // 教室信息
    @Column(name = "lessons")
    private int lessons; // 总课时
    @Column(name = "alive")
    private int alive; // 课程状态（0为正常 1为注销）

    public Course() {

    }

    public Course(String name, String startTime, String endTime, String info, String teacherId, int lessons, int
            alive) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.info = info;
        this.teacherId = teacherId;
        this.lessons = lessons;
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", info='" + info + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", lessons=" + lessons +
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getLessons() {
        return lessons;
    }

    public void setLessons(int lessons) {
        this.lessons = lessons;
    }

    public int getAlive() {
        return alive;
    }

    public void setAlive(int alive) {
        this.alive = alive;
    }
}
