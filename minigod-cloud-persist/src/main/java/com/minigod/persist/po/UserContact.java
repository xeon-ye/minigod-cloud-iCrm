package com.minigod.persist.po;
import com.minigod.persist.tables.TUserContact;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户联系人表
 */
@Entity(table=TUserContact.class)
public class UserContact implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer contactId;//关系链ID
	private Integer userId;//用户ID
	private Integer certType;//凭证类型(0-手机,1-邮箱,2-微信,3-微博,4-QQ)
	private String certCode;
	private String relaName;
	private Integer deviceId;
	private Boolean isStatus = true;//记录状态(0-无效，默认1-有效)
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间

    public Integer getContactId () {
        return contactId;
    }

    public void setContactId (Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getCertType () {
        return certType;
    }

    public void setCertType (Integer certType) {
        this.certType = certType;
    }

    public String getCertCode () {
        return certCode;
    }

    public void setCertCode (String certCode) {
        this.certCode = certCode;
    }

    public String getRelaName () {
        return relaName;
    }

    public void setRelaName (String relaName) {
        this.relaName = relaName;
    }

    public Integer getDeviceId () {
        return deviceId;
    }

    public void setDeviceId (Integer deviceId) {
        this.deviceId = deviceId;
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