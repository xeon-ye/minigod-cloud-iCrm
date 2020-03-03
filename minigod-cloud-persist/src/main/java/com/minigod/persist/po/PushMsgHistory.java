package com.minigod.persist.po;
import com.minigod.persist.tables.TPushMsgHistory;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 推送消息历史表
 */
@Entity(table=TPushMsgHistory.class)
public class PushMsgHistory implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer tempCode;//模板编码
	private Integer osType;//客户端类型(0-安卓，1-IOS，2-WP系统，3-全部)
	private String msgGroup;//消息分组(P-个人，A-全站，L-标签用户，T-用户分组)
	private Integer targetId;//msg_group=P时,记录为用户id;当msg_group=A时,为0
	private String content;
	private Integer sendStatus = 0;//推送状态(0-未发送 1-发送成功 2-发送失败)
	private Date sendTime;//发送时间
	private Date createTime;//创建时间
	private Integer relationId;//关联id

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getTempCode () {
        return tempCode;
    }

    public void setTempCode (Integer tempCode) {
        this.tempCode = tempCode;
    }

    public Integer getOsType () {
        return osType;
    }

    public void setOsType (Integer osType) {
        this.osType = osType;
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

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public Integer getSendStatus () {
        return sendStatus;
    }

    public void setSendStatus (Integer sendStatus) {
        this.sendStatus = sendStatus;
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

    public Integer getRelationId () {
        return relationId;
    }

    public void setRelationId (Integer relationId) {
        this.relationId = relationId;
    }
}