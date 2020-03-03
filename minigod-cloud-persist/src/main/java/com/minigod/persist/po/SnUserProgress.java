package com.minigod.persist.po;
import com.minigod.persist.tables.TSnUserProgress;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户任务进度表
 */
@Entity(table=TSnUserProgress.class)
public class SnUserProgress implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer userProgressId;
	private Integer userId;//用户id
	private Long taskId;//任务id
	private Integer featId;//功勋id,如果有的话
	private String taskName;//任务名称
	private String realDes;//任务的真正名称
	private Integer targetNum;//目标数字
	private Integer curNum;//当前进展
	private BigDecimal progressRate;//进度比率
	private Date gmtFinish;//完成时间(任务达到100%的时间)
	private Integer receiveStatus;//领取奖励的状态(0:不可领取, 1:可以领取,但尚未领取, 2:可以领取,且已经领取)
	private String taskStatus;//任务对于当前角色 所处的状态(nostart:没开始; over:已关闭; in_progress: 进行中,包括进度100%的可以继续做)
	private String finishStatus;//是否成功(in_progress, fail, success)
	private Integer effectiveDay;//生效日期
	private String eventCode;//任务所属的事件类型
	private String taskType;//任务的任务类型
	private Integer showIdx;//显示的顺序
	private Integer coin;//任务完成可以领取的金币值
	private Integer experience;//任务完成可以领取的经验值
	private Boolean isDeleted;//是否删除
	private String creator;//创建者
	private Date createTime;//创建时间
	private String modifier;//修改者
	private Date updateTime;//修改时间
	private String calType;//任务的计算类型, (暂定)一次性:onetime, 连续性:continuity, 每个:everyone, 每次: everytime

    public Integer getUserProgressId () {
        return userProgressId;
    }

    public void setUserProgressId (Integer userProgressId) {
        this.userProgressId = userProgressId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Long getTaskId () {
        return taskId;
    }

    public void setTaskId (Long taskId) {
        this.taskId = taskId;
    }

    public Integer getFeatId () {
        return featId;
    }

    public void setFeatId (Integer featId) {
        this.featId = featId;
    }

    public String getTaskName () {
        return taskName;
    }

    public void setTaskName (String taskName) {
        this.taskName = taskName;
    }

    public String getRealDes () {
        return realDes;
    }

    public void setRealDes (String realDes) {
        this.realDes = realDes;
    }

    public Integer getTargetNum () {
        return targetNum;
    }

    public void setTargetNum (Integer targetNum) {
        this.targetNum = targetNum;
    }

    public Integer getCurNum () {
        return curNum;
    }

    public void setCurNum (Integer curNum) {
        this.curNum = curNum;
    }

    public BigDecimal getProgressRate () {
        return progressRate;
    }

    public void setProgressRate (BigDecimal progressRate) {
        this.progressRate = progressRate;
    }

    public Date getGmtFinish () {
        return gmtFinish;
    }

    public void setGmtFinish (Date gmtFinish) {
        this.gmtFinish = gmtFinish;
    }

    public Integer getReceiveStatus () {
        return receiveStatus;
    }

    public void setReceiveStatus (Integer receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public String getTaskStatus () {
        return taskStatus;
    }

    public void setTaskStatus (String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getFinishStatus () {
        return finishStatus;
    }

    public void setFinishStatus (String finishStatus) {
        this.finishStatus = finishStatus;
    }

    public Integer getEffectiveDay () {
        return effectiveDay;
    }

    public void setEffectiveDay (Integer effectiveDay) {
        this.effectiveDay = effectiveDay;
    }

    public String getEventCode () {
        return eventCode;
    }

    public void setEventCode (String eventCode) {
        this.eventCode = eventCode;
    }

    public String getTaskType () {
        return taskType;
    }

    public void setTaskType (String taskType) {
        this.taskType = taskType;
    }

    public Integer getShowIdx () {
        return showIdx;
    }

    public void setShowIdx (Integer showIdx) {
        this.showIdx = showIdx;
    }

    public Integer getCoin () {
        return coin;
    }

    public void setCoin (Integer coin) {
        this.coin = coin;
    }

    public Integer getExperience () {
        return experience;
    }

    public void setExperience (Integer experience) {
        this.experience = experience;
    }

    public Boolean getIsDeleted () {
        return isDeleted;
    }

    public void setIsDeleted (Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreator () {
        return creator;
    }

    public void setCreator (String creator) {
        this.creator = creator;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier () {
        return modifier;
    }

    public void setModifier (String modifier) {
        this.modifier = modifier;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCalType () {
        return calType;
    }

    public void setCalType (String calType) {
        this.calType = calType;
    }
}