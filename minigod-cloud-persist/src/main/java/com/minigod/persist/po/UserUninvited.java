package com.minigod.persist.po;
import com.minigod.persist.tables.TUserUninvited;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 未邀请登陆失败统计表
 */
@Entity(table=TUserUninvited.class)
public class UserUninvited implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer uninvitedId;//登陆失败ID
	private Integer certType;//登陆凭证类型
	private String certCode;
	private String ip;
	private String imageUrl;
	private String nickName;
	private Integer gender;//用户性别
	private Integer deviceType;//设备类型
	private String deviceModel;
	private Integer osType;//操作系统类型
	private String osVersoin;
	private String appVersion;
	private String channel;
	private Date lastAttempt;//最后一次登陆失败时间
	private Integer failedTimes;//登陆失败尝试次数
	private Boolean isStatus = true;//记录状态
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间

    public Integer getUninvitedId () {
        return uninvitedId;
    }

    public void setUninvitedId (Integer uninvitedId) {
        this.uninvitedId = uninvitedId;
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

    public String getIp () {
        return ip;
    }

    public void setIp (String ip) {
        this.ip = ip;
    }

    public String getImageUrl () {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNickName () {
        return nickName;
    }

    public void setNickName (String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender () {
        return gender;
    }

    public void setGender (Integer gender) {
        this.gender = gender;
    }

    public Integer getDeviceType () {
        return deviceType;
    }

    public void setDeviceType (Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceModel () {
        return deviceModel;
    }

    public void setDeviceModel (String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public Integer getOsType () {
        return osType;
    }

    public void setOsType (Integer osType) {
        this.osType = osType;
    }

    public String getOsVersoin () {
        return osVersoin;
    }

    public void setOsVersoin (String osVersoin) {
        this.osVersoin = osVersoin;
    }

    public String getAppVersion () {
        return appVersion;
    }

    public void setAppVersion (String appVersion) {
        this.appVersion = appVersion;
    }

    public String getChannel () {
        return channel;
    }

    public void setChannel (String channel) {
        this.channel = channel;
    }

    public Date getLastAttempt () {
        return lastAttempt;
    }

    public void setLastAttempt (Date lastAttempt) {
        this.lastAttempt = lastAttempt;
    }

    public Integer getFailedTimes () {
        return failedTimes;
    }

    public void setFailedTimes (Integer failedTimes) {
        this.failedTimes = failedTimes;
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