package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserQuestionFlow;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdviserQuestionFlow.class)
public class AdviserQuestionFlow implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer questionFlowId;//流转ID
	private Integer questionId;//问题id
	private Integer questionUserId;//提问用户id
	private Integer answerUserId;//回答用户id
	private Integer flowStatus = 0;//流转状态 默认0待抢答，1已被抢答,2已抢未答， 3放弃，4超时，9已回答
	private Boolean isRead = false;//默认0未读，1已读对回答者而言，flow_status=0且未读需打点
	private String reportContent;//举报内容
	private Date reportTime;//举报时间
	private Date rushTime;//抢答时间
	private Boolean isStatus = true;//记录状态 0-无效，默认1-有效
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getQuestionFlowId () {
        return questionFlowId;
    }

    public void setQuestionFlowId (Integer questionFlowId) {
        this.questionFlowId = questionFlowId;
    }

    public Integer getQuestionId () {
        return questionId;
    }

    public void setQuestionId (Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionUserId () {
        return questionUserId;
    }

    public void setQuestionUserId (Integer questionUserId) {
        this.questionUserId = questionUserId;
    }

    public Integer getAnswerUserId () {
        return answerUserId;
    }

    public void setAnswerUserId (Integer answerUserId) {
        this.answerUserId = answerUserId;
    }

    public Integer getFlowStatus () {
        return flowStatus;
    }

    public void setFlowStatus (Integer flowStatus) {
        this.flowStatus = flowStatus;
    }

    public Boolean getIsRead () {
        return isRead;
    }

    public void setIsRead (Boolean isRead) {
        this.isRead = isRead;
    }

    public String getReportContent () {
        return reportContent;
    }

    public void setReportContent (String reportContent) {
        this.reportContent = reportContent;
    }

    public Date getReportTime () {
        return reportTime;
    }

    public void setReportTime (Date reportTime) {
        this.reportTime = reportTime;
    }

    public Date getRushTime () {
        return rushTime;
    }

    public void setRushTime (Date rushTime) {
        this.rushTime = rushTime;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }
}