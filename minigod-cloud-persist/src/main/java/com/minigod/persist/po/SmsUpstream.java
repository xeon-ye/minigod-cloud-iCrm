package com.minigod.persist.po;
import com.minigod.persist.tables.TSmsUpstream;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSmsUpstream.class)
public class SmsUpstream implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer upstreamId;//短信上行接收
	private String channel;//短信通道
	private String mobile;//手机号码
	private String content;//上行短信的内容
	private Date sendTime;//上行短信的发送的时间
	private Date createTime;//记录创建时间
	private Date updateTime;//记录更新时间

    public Integer getUpstreamId () {
        return upstreamId;
    }

    public void setUpstreamId (Integer upstreamId) {
        this.upstreamId = upstreamId;
    }

    public String getChannel () {
        return channel;
    }

    public void setChannel (String channel) {
        this.channel = channel;
    }

    public String getMobile () {
        return mobile;
    }

    public void setMobile (String mobile) {
        this.mobile = mobile;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public Date getSendTime () {
        return sendTime;
    }

    public void setSendTime (Date sendTime) {
        this.sendTime = sendTime;
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