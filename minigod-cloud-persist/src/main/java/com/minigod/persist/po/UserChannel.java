package com.minigod.persist.po;
import com.minigod.persist.tables.TUserChannel;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户交易渠道表
 */
@Entity(table=TUserChannel.class)
public class UserChannel implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer userChannelId;//用户交易渠道ID;非自增长ID（以便根据本字段生成齐牛OPENID，一次性入库）
	private Integer userId;//用户ID
	private Integer channelId;//渠道ID;如iTN、国信直连、广发直连等
	private String qnOpenid;
	private String outOpenid;
	private String currentStatus;//当前状态;N-未绑定（仅生成qn_openid）,B-已绑定,C-已解绑
	private Date bindTime;//绑定时间
	private Date cancelTime;//解绑时间
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getUserChannelId () {
        return userChannelId;
    }

    public void setUserChannelId (Integer userChannelId) {
        this.userChannelId = userChannelId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getChannelId () {
        return channelId;
    }

    public void setChannelId (Integer channelId) {
        this.channelId = channelId;
    }

    public String getQnOpenid () {
        return qnOpenid;
    }

    public void setQnOpenid (String qnOpenid) {
        this.qnOpenid = qnOpenid;
    }

    public String getOutOpenid () {
        return outOpenid;
    }

    public void setOutOpenid (String outOpenid) {
        this.outOpenid = outOpenid;
    }

    public String getCurrentStatus () {
        return currentStatus;
    }

    public void setCurrentStatus (String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Date getBindTime () {
        return bindTime;
    }

    public void setBindTime (Date bindTime) {
        this.bindTime = bindTime;
    }

    public Date getCancelTime () {
        return cancelTime;
    }

    public void setCancelTime (Date cancelTime) {
        this.cancelTime = cancelTime;
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
}