package com.minigod.persist.po;
import com.minigod.persist.tables.TUserDevice;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户设备表
 */
@Entity(table=TUserDevice.class)
public class UserDevice implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer deviceId;//设备ID
	private Integer userId;//用户ID
	private Integer guestFlag = 0;//当为游客时值为0，转为正式用户时值为user_id，已经是正式用户绑定新设备时直接存user_id。
	private Integer deviceType;//设备类型(0PC;1手机;2平板)
	private String deviceModel;
	private Integer osType;//操作系统类型(0安卓，1苹果，2WP)
	private String osVersoin;
	private String appVersion;
	private String deviceName;
	private String deviceCode;
	private String openToken;
	private String openCode;
	private String regChannel;//注册的渠道
	private String channel;//当前使用的渠道
	private String authFlag;
	private Integer pushConfig = -1;//0表示关闭了通知，1(1<<0)表示开启了应用图标提醒，2(1<<1)表示开启声音提醒，4(1<<2)表示开启弹窗提醒 8(1<<3)不用管。复选的时候数字简单相加。默认为-1，表示未知。
	private Date configUpdateTime;//APP端系统推送设置信息更新时间。默认为空，push_config字段更新时更新
	private Boolean isStatus = true;//状态(手机丢失后，用户可以禁用该设备,1正常使用，0禁用)
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间

    public Integer getDeviceId () {
        return deviceId;
    }

    public void setDeviceId (Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getGuestFlag () {
        return guestFlag;
    }

    public void setGuestFlag (Integer guestFlag) {
        this.guestFlag = guestFlag;
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

    public String getDeviceName () {
        return deviceName;
    }

    public void setDeviceName (String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCode () {
        return deviceCode;
    }

    public void setDeviceCode (String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getOpenToken () {
        return openToken;
    }

    public void setOpenToken (String openToken) {
        this.openToken = openToken;
    }

    public String getOpenCode () {
        return openCode;
    }

    public void setOpenCode (String openCode) {
        this.openCode = openCode;
    }

    public String getRegChannel () {
        return regChannel;
    }

    public void setRegChannel (String regChannel) {
        this.regChannel = regChannel;
    }

    public String getChannel () {
        return channel;
    }

    public void setChannel (String channel) {
        this.channel = channel;
    }

    public String getAuthFlag () {
        return authFlag;
    }

    public void setAuthFlag (String authFlag) {
        this.authFlag = authFlag;
    }

    public Integer getPushConfig () {
        return pushConfig;
    }

    public void setPushConfig (Integer pushConfig) {
        this.pushConfig = pushConfig;
    }

    public Date getConfigUpdateTime () {
        return configUpdateTime;
    }

    public void setConfigUpdateTime (Date configUpdateTime) {
        this.configUpdateTime = configUpdateTime;
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