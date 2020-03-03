package com.minigod.persist.po;
import com.minigod.persist.tables.TSysMsg;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSysMsg.class)
public class SysMsg implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer msgId;//消息id
	private String msgGroup;//消息分组(P-个人,A-全站)
	private Integer targetId;//msg_group=P时,记录为用户id;当msg_group=A时,为0
	private String msgType;//消息类型
	private String msgLevel;//消息级别(I-重要G-普通)
	private String msgTitle;
	private String msgContent;
	private String url;
	private Long updVersion;//更新版本号
	private Integer oprId;//操作人id
	private String oprName;
	private Boolean isStatus;//是否有效0-无效，1-有效
	private Date createTime;//创建时间
	private Date updateTime;//更新时间

    public Integer getMsgId () {
        return msgId;
    }

    public void setMsgId (Integer msgId) {
        this.msgId = msgId;
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

    public String getMsgTitle () {
        return msgTitle;
    }

    public void setMsgTitle (String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgContent () {
        return msgContent;
    }

    public void setMsgContent (String msgContent) {
        this.msgContent = msgContent;
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