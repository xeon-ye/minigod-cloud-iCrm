package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserOpenInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdviserOpenInfo.class)
public class AdviserOpenInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer adviserOpenId;//自增长
	private Integer userId;//投顾用户id
	private String openActivity;//开户活动
	private String openBrokerage;//开户佣金
	private String openPrivilege;//开户专享特权,以|分隔符保存起来，获取直接以数组形式给前端
	private String openInstruction;//开户说明
	private String openUrl;//开户链接
	private String appIosPackage;//ios包名
	private String appAndroidPackage;//android包名
	private String channelParm;//渠道参数标识，追加到open_url后面
	private Boolean isStatus = true;//0-无效，默认1-有效
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getAdviserOpenId () {
        return adviserOpenId;
    }

    public void setAdviserOpenId (Integer adviserOpenId) {
        this.adviserOpenId = adviserOpenId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getOpenActivity () {
        return openActivity;
    }

    public void setOpenActivity (String openActivity) {
        this.openActivity = openActivity;
    }

    public String getOpenBrokerage () {
        return openBrokerage;
    }

    public void setOpenBrokerage (String openBrokerage) {
        this.openBrokerage = openBrokerage;
    }

    public String getOpenPrivilege () {
        return openPrivilege;
    }

    public void setOpenPrivilege (String openPrivilege) {
        this.openPrivilege = openPrivilege;
    }

    public String getOpenInstruction () {
        return openInstruction;
    }

    public void setOpenInstruction (String openInstruction) {
        this.openInstruction = openInstruction;
    }

    public String getOpenUrl () {
        return openUrl;
    }

    public void setOpenUrl (String openUrl) {
        this.openUrl = openUrl;
    }

    public String getAppIosPackage () {
        return appIosPackage;
    }

    public void setAppIosPackage (String appIosPackage) {
        this.appIosPackage = appIosPackage;
    }

    public String getAppAndroidPackage () {
        return appAndroidPackage;
    }

    public void setAppAndroidPackage (String appAndroidPackage) {
        this.appAndroidPackage = appAndroidPackage;
    }

    public String getChannelParm () {
        return channelParm;
    }

    public void setChannelParm (String channelParm) {
        this.channelParm = channelParm;
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