package com.minigod.persist.po;
import com.minigod.persist.tables.TInvestMsg;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TInvestMsg.class)
public class InvestMsg implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer msgId;//信息ID
	private Integer ptfId;
	private Integer userId;//用户ID
	private Integer fromUser;//发表人ID
	private String msgType;//消息类型
	private Integer displayGroup = 2001;//消息显示分组
	private String title;//消息标题
	private String msgContent;
	private String relaType;//关联对象类型
	private Long relaId;//关联对象ID
	private String relaText;
	private String srcType;//源表类型
	private Integer srcId;//源表ID
	private Boolean isStatus;//是否有效
	private Long updVersion;//更新版本号
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Date sendTime;//推送时间,推送方式为定时时,不为空
	private Integer sendStatus = 0;//推送状态(0-未发送，1-已发送 2-发送失败)
	private Integer sendWay;//推送方式(0-即时 1-定时)
	private String msgGroup;//消息分组(P-个人，A-全站，L-标签用户，T-用户分组)
	private Integer clientType = 0;//客户端类型(0-全部终端 1-Android 2-IOS)

    public Integer getMsgId () {
        return msgId;
    }

    public void setMsgId (Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getFromUser () {
        return fromUser;
    }

    public void setFromUser (Integer fromUser) {
        this.fromUser = fromUser;
    }

    public String getMsgType () {
        return msgType;
    }

    public void setMsgType (String msgType) {
        this.msgType = msgType;
    }

    public Integer getDisplayGroup () {
        return displayGroup;
    }

    public void setDisplayGroup (Integer displayGroup) {
        this.displayGroup = displayGroup;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getMsgContent () {
        return msgContent;
    }

    public void setMsgContent (String msgContent) {
        this.msgContent = msgContent;
    }

    public String getRelaType () {
        return relaType;
    }

    public void setRelaType (String relaType) {
        this.relaType = relaType;
    }

    public Long getRelaId () {
        return relaId;
    }

    public void setRelaId (Long relaId) {
        this.relaId = relaId;
    }

    public String getRelaText () {
        return relaText;
    }

    public void setRelaText (String relaText) {
        this.relaText = relaText;
    }

    public String getSrcType () {
        return srcType;
    }

    public void setSrcType (String srcType) {
        this.srcType = srcType;
    }

    public Integer getSrcId () {
        return srcId;
    }

    public void setSrcId (Integer srcId) {
        this.srcId = srcId;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
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

    public Integer getSendWay () {
        return sendWay;
    }

    public void setSendWay (Integer sendWay) {
        this.sendWay = sendWay;
    }

    public String getMsgGroup () {
        return msgGroup;
    }

    public void setMsgGroup (String msgGroup) {
        this.msgGroup = msgGroup;
    }

    public Integer getClientType () {
        return clientType;
    }

    public void setClientType (Integer clientType) {
        this.clientType = clientType;
    }
}