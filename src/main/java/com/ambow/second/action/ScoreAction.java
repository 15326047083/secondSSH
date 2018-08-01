package com.ambow.second.action;


import com.ambow.second.entity.Score;
import com.ambow.second.service.IScoreService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;


@Namespace("/score")
public class ScoreAction extends ActionSupport {
    @Autowired
    private IScoreService scoreService;
    private Score score;
    private  String scoreId;
    private  String scores;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;


    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }


    /**
     * 查询个人成绩
     * @return
     */

    @Action(value = "getAll", results = {@Result(name = "success", location = "/WEB-INF/page/score/list.jsp")})
    public String getAll(){

        ActionContext context=ActionContext.getContext();
        context.put("getAll",scoreService.getScoreByuserId("2"));

        return SUCCESS;
    }
    /**
     *单查
     */
    @Action(value = "getById", results = {@Result(name = "success", location = "/WEB-INF/page/score/new.jsp")},params = {"scoreId","%{scoreId}"})
    public String getById(){

        ActionContext context=ActionContext.getContext();

        context.put("getById",scoreService.getScoreById(this.scoreId));
        return  SUCCESS;
    }



    /**
     * 保存或修改成绩
     * @return
     */
    @Action(value = "updateScore", results = {@Result(name="success",location = "getAll.action",type = "redirect")})
    public  String updateScore(){
        score=scoreService.get(id);
        score.setScore(scores);
        scoreService.saveorUpdateScore(score);
        return SUCCESS;
    }


    /**
     * 删除成绩
     */

    @Action(value = "deleteScore",results = {@Result(name="success",location = "getAll.action",type = "redirect")}, params = {"scoreId","%{scoreId}"})

    public  String deleteScore(){
        scoreService.deleteScore(this.scoreId);
        return SUCCESS;
    }


}
