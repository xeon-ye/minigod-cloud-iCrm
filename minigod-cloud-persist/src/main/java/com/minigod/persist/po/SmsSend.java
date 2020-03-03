package com.minigod.persist.po;
import com.minigod.persist.tables.TSmsSend;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 短信信息发送表
 */
@Entity(table=TSmsSend.class)
public class SmsSend implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer smsSendId;//短信发送id
	private String appCode;//app编码
	private String templateCode;//模板编码
	private String extension;//业务扩展码，用于区分各种业务
	private String phoneNumber;
	private String message;
	private String channel;
	private Integer sendStatus;//发送状态
	private String rtnMsg;
	private Boolean failureResend;//失败是否重发。1重发；0不重发
	private Integer failureNum;//失败次数。目前约定失败3次不再重发
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Boolean isStatus;//记录是否有效

    public Integer getSmsSendId () {
        return smsSendId;
    }

    public void setSmsSendId (Integer smsSendId) {
        this.smsSendId = smsSendId;
    }

    public String getAppCode () {
        return appCode;
    }

    public void setAppCode (String appCode) {
        this.appCode = appCode;
    }

    public String getTemplateCode () {
        return templateCode;
    }

    public void setTemplateCode (String templateCode) {
        this.templateCode = templateCode;
    }

    public String getExtension () {
        return extension;
    }

    public void setExtension (String extension) {
        this.extension = extension;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public String getChannel () {
        return channel;
    }

    public void setChannel (String channel) {
        this.channel = channel;
    }

    public Integer getSendStatus () {
        return sendStatus;
    }

    public void setSendStatus (Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getRtnMsg () {
        return rtnMsg;
    }

    public void setRtnMsg (String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }

    public Boolean getFailureResend () {
        return failureResend;
    }

    public void setFailureResend (Boolean failureResend) {
        this.failureResend = failureResend;
    }

    public Integer getFailureNum () {
        return failureNum;
    }

    public void setFailureNum (Integer failureNum) {
        this.failureNum = failureNum;
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

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }
}