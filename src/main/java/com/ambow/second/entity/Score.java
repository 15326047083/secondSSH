package com.ambow.second.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 成绩
 */
@Entity
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id; // 主键
    @Column(name = "userId")
    private String userId; // 学员ID
    @Column(name = "courseId")
    private String courseId; // 课程ID
    @Column(name = "score")
    private String score; // 成绩
    @Column(name = "info")
    private String info; // 详情

    public Score() {

    }

    public Score(String userId, String courseId, String score, String info) {
        this.userId = userId;
        this.courseId = courseId;
        this.score = score;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", score='" + score + '\'' +
                ", info='" + info + '\'' +
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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
