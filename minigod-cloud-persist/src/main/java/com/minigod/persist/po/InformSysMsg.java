package com.minigod.persist.po;
import com.minigod.persist.tables.TInformSysMsg;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统通知信息表
 */
@Entity(table=TInformSysMsg.class)
public class InformSysMsg implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private String msgType;//消息类型(A:活动 R:提醒 N:公告 X:要闻 B:播报)
	private String msgLevel;//消息级别(I:重要 G:普通)
	private Integer tempCode;//通知模板编码
	private String title;//标题
	private String content;//通知内容
	private Integer clientType;//客户端类型(0-全部终端 1-Android 2-IOS)
	private String msgGroup;//消息分组(P-个人，A-全站，L-标签用户，T-用户分组)
	private Integer targetId;//msg_group=P时,记录为用户id;当msg_group=A时,为0
	private Integer sendType;//推送类型(0-强消息 1-弱消息)
	private Integer sendWay;//推送方式(0-即时 1-定时)
	private Date sendTime;//推送时间,推送方式为定时时,不为空
	private Integer sendStatus = 0;//推送状态(0-未发送，1-已发送 2-发送失败)
	private Integer retryCnt = 0;//重发次数
	private Integer oprId;//权限审核人ID
	private String oprName;//权限审核人名称
	private String url;//跳转页面地址
	private Long updVersion;//更新版本号
	private Date createTime = new Date();//创建时间
	private Date updateTime = new Date();//更新时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getMsgType () {
        return msgType;
    }

    public void setMsgType (String msgType) {
        this.msgType = msgType;
    }

    public String getMsgLevel () {
        return msgLevel;
    }

    public void setMsgLevel (String msgLevel) {
        this.msgLevel = msgLevel;
    }

    public Integer getTempCode () {
        return tempCode;
    }

    public void setTempCode (Integer tempCode) {
        this.tempCode = tempCode;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public Integer getClientType () {
        return clientType;
    }

    public void setClientType (Integer clientType) {
        this.clientType = clientType;
    }

    public String getMsgGroup () {
        return msgGroup;
    }

    public void setMsgGroup (String msgGroup) {
        this.msgGroup = msgGroup;
    }

    public Integer getTargetId () {
        return targetId;
    }

    public void setTargetId (Integer targetId) {
        this.targetId = targetId;
    }

    public Integer getSendType () {
        return sendType;
    }

    public void setSendType (Integer sendType) {
        this.sendType = sendType;
    }

    public Integer getSendWay () {
        return sendWay;
    }

    public void setSendWay (Integer sendWay) {
        this.sendWay = sendWay;
    }

    public Date getSendTime () {
        return sendTime;
    }

    public void setSendTime (Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getSendStatus () {
        return sendStatus;
    }

    public void setSendStatus (Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Integer getRetryCnt () {
        return retryCnt;
    }

    public void setRetryCnt (Integer retryCnt) {
        this.retryCnt = retryCnt;
    }

    public Integer getOprId () {
        return oprId;
    }

    public void setOprId (Integer oprId) {
        this.oprId = oprId;
    }

    public String getOprName () {
        return oprName;
    }

    public void setOprName (String oprName) {
        this.oprName = oprName;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public Long getUpdVersion () {
        return updVersion;
    }

    public void setUpdVersion (Long updVersion) {
        this.updVersion = updVersion;
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