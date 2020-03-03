package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserAnswer;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdviserAnswer.class)
public class AdviserAnswer implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer answerId;//答案ID
	private Integer questionId;//问题id
	private Integer questionUserId;//提问用户id
	private Integer answerUserId;//回答用户id
	private String content;//答案内容
	private Integer isSatisfy;//评价，0不满意 1满意，默认空
	private Integer unsatisfyType;//不满意类型
	private String unsatisfyReason;//若不满意类型为其它则记录不满意原因
	private Boolean isRead = false;//是否已读，默认0未读，1已读 。  对于提问者而言未读需打点 
	private Boolean isStatus = true;//记录状态 0-无效，默认1
	private Date createTime;//创建时间 回答时间
	private Date updateTime;//修改时间

    public Integer getAnswerId () {
        return answerId;
    }

    public void setAnswerId (Integer answerId) {
        this.answerId = answerId;
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

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public Integer getIsSatisfy () {
        return isSatisfy;
    }

    public void setIsSatisfy (Integer isSatisfy) {
        this.isSatisfy = isSatisfy;
    }

    public Integer getUnsatisfyType () {
        return unsatisfyType;
    }

    public void setUnsatisfyType (Integer unsatisfyType) {
        this.unsatisfyType = unsatisfyType;
    }

    public String getUnsatisfyReason () {
        return unsatisfyReason;
    }

    public void setUnsatisfyReason (String unsatisfyReason) {
        this.unsatisfyReason = unsatisfyReason;
    }

    public Boolean getIsRead () {
        return isRead;
    }

    public void setIsRead (Boolean isRead) {
        this.isRead = isRead;
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