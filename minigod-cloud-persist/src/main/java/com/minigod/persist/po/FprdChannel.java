package com.minigod.persist.po;
import com.minigod.persist.tables.TFprdChannel;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TFprdChannel.class)
public class FprdChannel implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer fprdChannelId;//理财用户渠道ID
	private Integer userId;//用户ID
	private Integer channelId;//渠道ID
	private Integer sequence;//绑定序号
	private String qnOpenid;//齐牛OPENID
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getFprdChannelId () {
        return fprdChannelId;
    }

    public void setFprdChannelId (Integer fprdChannelId) {
        this.fprdChannelId = fprdChannelId;
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

    public Integer getSequence () {
        return sequence;
    }

    public void setSequence (Integer sequence) {
        this.sequence = sequence;
    }

    public String getQnOpenid () {
        return qnOpenid;
    }

    public void setQnOpenid (String qnOpenid) {
        this.qnOpenid = qnOpenid;
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