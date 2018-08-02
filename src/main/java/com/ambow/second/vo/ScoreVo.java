package com.ambow.second.vo;

public class ScoreVo {

    private String courseId;//课程Id
    private String courseName;//课程名称
    private String teacherId;//教师Id

    private String userName;//用户名称
    private String scoreId;//成绩Id
    private String score;//成绩
    private int courseLessons;//课时


    @Override
    public String toString() {
        return "ScoreVo{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", userName='" + userName + '\'' +
                ", scoreId='" + scoreId + '\'' +
                ", score='" + score + '\'' +
                ", courseLessons=" + courseLessons +
                '}';
    }

    public ScoreVo() {

    }

    public ScoreVo(String courseId, String courseName, String teacherId, String userName, String scoreId, String score, int courseLessons) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.userName = userName;
        this.scoreId = scoreId;
        this.score = score;
        this.courseLessons = courseLessons;
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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getCourseLessons() {
        return courseLessons;
    }

    public void setCourseLessons(int courseLessons) {
        this.courseLessons = courseLessons;
    }
}