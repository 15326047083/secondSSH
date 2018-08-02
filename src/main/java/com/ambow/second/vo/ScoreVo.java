package com.ambow.second.vo;

public class ScoreVo {

    private  String courseId;//课程Id
    private  String courseName;//课程名称
    private  String teacherId;//教师Id
    private  String teacherName;//教师名称
    private  String scoreId;//成绩Id
    private  String score;//成绩
    private  int  courseLessons;//课时

    @Override
    public String toString() {
        return "ScoreVo{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", scoreId='" + scoreId + '\'' +
                ", score='" + score + '\'' +
                ", courseLessons=" + courseLessons +
                '}';
    }

    public ScoreVo()
    {

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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public ScoreVo(String courseId, String courseName, String teacherId, String teacherName, String scoreId, String score, int courseLessons) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.scoreId = scoreId;
        this.score = score;
        this.courseLessons = courseLessons;
    }
}
