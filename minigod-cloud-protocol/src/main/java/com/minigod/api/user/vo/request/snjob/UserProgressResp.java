package com.minigod.api.user.vo.request.snjob;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chenyouhuo
 * @version v1.0
 * @Project: minigod
 * @Description: 用户进度返回类
 * @Copyright: © 2016 minigod
 * @Company: minigod
 * @date 2016/11/17 11:03
 */
public class UserProgressResp implements Serializable {

    private static final long serialVersionUID = -377681169728835090L;
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
    private Integer receiveStatus;//领取金币的状态(0:不可领取, 1:可以领取,但尚未领取, 2:可以领取,且已经领取)
    private String taskStatus;//任务对于当前角色 所处的状态(nostart:没开始; over:已关闭; in_progress: 进行中,包括进度100%的可以继续做)
    private String finishStatus;//是否成功(in_progress, fail, success)
    private String eventCode;//任务所属的事件类型
    private String taskType;//任务的任务类型
    private Integer coin;//任务完成可以领取的金币值
    private Integer experience;//任务完成可以领取的经验值
    private String calType;//任务的计算类型, (暂定)一次性:onetime, 连续性:continuity, 每个:everyone, 每次: everytime
    private Integer isDoneToday;//今天是否已经做了任务

    public Integer getUserProgressId() {
        return userProgressId;
    }

    public void setUserProgressId(Integer userProgressId) {
        this.userProgressId = userProgressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Integer getFeatId() {
        return featId;
    }

    public void setFeatId(Integer featId) {
        this.featId = featId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getRealDes() {
        return realDes;
    }

    public void setRealDes(String realDes) {
        this.realDes = realDes;
    }

    public Integer getTargetNum() {
        return targetNum;
    }

    public void setTargetNum(Integer targetNum) {
        this.targetNum = targetNum;
    }

    public Integer getCurNum() {
        return curNum;
    }

    public void setCurNum(Integer curNum) {
        this.curNum = curNum;
    }

    public BigDecimal getProgressRate() {
        return progressRate;
    }

    public void setProgressRate(BigDecimal progressRate) {
        this.progressRate = progressRate;
    }

    public Date getGmtFinish() {
        return gmtFinish;
    }

    public void setGmtFinish(Date gmtFinish) {
        this.gmtFinish = gmtFinish;
    }

    public Integer getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(Integer receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(String finishStatus) {
        this.finishStatus = finishStatus;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getCalType() {
        return calType;
    }

    public void setCalType(String calType) {
        this.calType = calType;
    }

    public Integer getIsDoneToday() {
        return isDoneToday;
    }

    public void setIsDoneToday(Integer isDoneToday) {
        this.isDoneToday = isDoneToday;
    }
}
