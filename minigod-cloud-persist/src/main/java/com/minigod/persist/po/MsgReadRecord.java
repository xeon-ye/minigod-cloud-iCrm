package com.minigod.persist.po;
import com.minigod.persist.tables.TMsgReadRecord;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TMsgReadRecord.class)
public class MsgReadRecord implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer msgReadRecordId;//消息读取记录表id
	private Integer userId;//用户id
	private Integer msgCode;//消息分类。2001(PTF)组合，2004(USER)新的好友
	private Integer msgChildCode = 0;//消息子分类
	private Long readVersion;//最后已读的时间戳或者id
	private Integer unreadNum;//未读消息数量
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion = 1;//乐观锁版本号
	private Boolean isStatus;//有效标志

    public Integer getMsgReadRecordId () {
        return msgReadRecordId;
    }

    public void setMsgReadRecordId (Integer msgReadRecordId) {
        this.msgReadRecordId = msgReadRecordId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getMsgCode () {
        return msgCode;
    }

    public void setMsgCode (Integer msgCode) {
        this.msgCode = msgCode;
    }

    public Integer getMsgChildCode () {
        return msgChildCode;
    }

    public void setMsgChildCode (Integer msgChildCode) {
        this.msgChildCode = msgChildCode;
    }

    public Long getReadVersion () {
        return readVersion;
    }

    public void setReadVersion (Long readVersion) {
        this.readVersion = readVersion;
    }

    public Integer getUnreadNum () {
        return unreadNum;
    }

    public void setUnreadNum (Integer unreadNum) {
        this.unreadNum = unreadNum;
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

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }
}