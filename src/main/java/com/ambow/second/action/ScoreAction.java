package com.ambow.second.action;


import com.ambow.second.entity.Course;
import com.ambow.second.entity.Score;
import com.ambow.second.entity.User;
import com.ambow.second.service.IScoreService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Namespace("/score")
public class ScoreAction extends ActionSupport {
    @Autowired
    private IScoreService scoreService;//scoreService
    private Score score;//score对象(jsp->action)
    private String scores;//修改后或新添加的成绩(jsp->action)
    private String scoreId;//成绩Id(jsp->action)

    private String userId;//添加的用户Id
    private String courseId;//添加的课程Id
    private String info;//成绩的详情

    private String like;//模糊查询的内容(jsp->action)

    private  int index;  //当前页数


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }


    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }


    /**
     * 查询个人成绩
     *
     * @return
     */

    @Action(value = "getAlluser", results = {@Result(name = "success", location = "/WEB-INF/page/score/list.jsp")})
    public String getAlluser() {

        long page=scoreService.countScoreVo();
        if (page%5==0){
            ActionContext.getContext().put("allPage",page/5);
        }
        else {
            ActionContext.getContext().put("allPage",page/5+1);
        }


        ActionContext context = ActionContext.getContext();
        context.put("getAll", scoreService.getScoreByuserId("2",index));
        context.put("index",index);

        return SUCCESS;
    }

    /**
     * 教师查询成绩
     *
     * @return
     */

    @Action(value = "getAllteacher", results = {@Result(name = "success", location = "/WEB-INF/page/score/list.jsp")})
    public String getAllteacher() {

        long page=scoreService.countScoreVo();
        if (page%5==0){
            ActionContext.getContext().put("allPage",page/5);
        }
        else {
            ActionContext.getContext().put("allPage",page/5+1);
        }


        ActionContext context = ActionContext.getContext();
        context.put("getAll", scoreService.getScoreByteacherId("2",index));

        context.put("index",index);

        return SUCCESS;
    }

    /**
     * 单查
     */
    @Action(value = "getById", results = {@Result(name = "success", location = "/WEB-INF/page/score/update.jsp")}, params = {"scoreId", "%{scoreId}"})
    public String getById() {

        ActionContext context = ActionContext.getContext();

        context.put("getById", scoreService.get(this.scoreId));
        return SUCCESS;
    }


    /**
     * 保存或修改成绩
     *
     * @return
     */
    @Action(value = "updateScore", results = {@Result(name = "success", location = "getAllteacher.action", type = "redirect")})
    public String updateScore() {
        score = scoreService.get(this.scoreId);
        score.setScore(scores);
        scoreService.saveorUpdateScore(score);
        return SUCCESS;
    }


    /**
     * 删除成绩
     */

    @Action(value = "deleteScore", results = {@Result(name = "success", location = "getAllteacher.action", type = "redirect")}, params = {"scoreId", "%{scoreId}"})

    public String deleteScore() {
        scoreService.deleteScore(this.scoreId);
        return SUCCESS;
    }

    /**
     * 跳转到新增成绩
     * 选择用户和课程名
     *
     * @return
     */
    @Action(value = "toNewScore", results = {@Result(name = "success", location = "/WEB-INF/page/score/new.jsp")})
    public String toNewScore() {
        List<User> userList = scoreService.getAllUser();
        List<Course> courseList = scoreService.getAllCourse();
        ActionContext.getContext().put("userList", userList);
        ActionContext.getContext().put("courseList", courseList);
        return SUCCESS;
    }

    /**
     * 添加成绩
     */
    @Action(value = "saveScore", results = {@Result(name = "success", location = "getAllteacher.action", type = "redirect")})
    public String saveScore() {
        scoreService.saveorUpdateScore(score);
        return SUCCESS;
    }

    /**
     * 模糊查询
     */

    @Action(value = "likeScore", results = {@Result(name = "success", location = "/WEB-INF/page/score/list.jsp")})
    public String likeScore() {

        ActionContext context = ActionContext.getContext();
        context.put("getAll", scoreService.getScoredBylike(like));


        return SUCCESS;
    }


}
