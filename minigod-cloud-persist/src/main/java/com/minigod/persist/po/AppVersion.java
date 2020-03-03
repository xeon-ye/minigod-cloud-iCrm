package com.minigod.persist.po;
import com.minigod.persist.tables.TAppVersion;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * APP版本信息表
 */
@Entity(table=TAppVersion.class)
public class AppVersion implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer appVerId;//APP版本ID
	private String versionNo;
	private String url;
	private String size;
	private String updateDeclare;
	private Integer deviceType;//设备类型(0PC;1手机;2平板)
	private Integer osType;//操作系统类型(0安卓，1苹果，2WP)
	private String channel;
	private String md5;
	private Integer checkCode;//升级状态(0为已是最新版本无须升级,1为有新版本，无须升级,2为有新版本，建议升级,3为有新版本，必须升级方可使用)
	private Boolean isNew;//是否最新版本(1是，0不是)
	private Integer isStatus;//状态(0停用，1正常使用，停用后不容许升级)
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间

    public Integer getAppVerId () {
        return appVerId;
    }

    public void setAppVerId (Integer appVerId) {
        this.appVerId = appVerId;
    }

    public String getVersionNo () {
        return versionNo;
    }

    public void setVersionNo (String versionNo) {
        this.versionNo = versionNo;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getSize () {
        return size;
    }

    public void setSize (String size) {
        this.size = size;
    }

    public String getUpdateDeclare () {
        return updateDeclare;
    }

    public void setUpdateDeclare (String updateDeclare) {
        this.updateDeclare = updateDeclare;
    }

    public Integer getDeviceType () {
        return deviceType;
    }

    public void setDeviceType (Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getOsType () {
        return osType;
    }

    public void setOsType (Integer osType) {
        this.osType = osType;
    }

    public String getChannel () {
        return channel;
    }

    public void setChannel (String channel) {
        this.channel = channel;
    }

    public String getMd5 () {
        return md5;
    }

    public void setMd5 (String md5) {
        this.md5 = md5;
    }

    public Integer getCheckCode () {
        return checkCode;
    }

    public void setCheckCode (Integer checkCode) {
        this.checkCode = checkCode;
    }

    public Boolean getIsNew () {
        return isNew;
    }

    public void setIsNew (Boolean isNew) {
        this.isNew = isNew;
    }

    public Integer getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Integer isStatus) {
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