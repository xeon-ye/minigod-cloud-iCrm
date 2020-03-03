package com.minigod.persist.po;

import com.minigod.persist.tables.TActivityUserPrivilegeExchange;
import com.minigod.db4j.annotation.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户特权兑换信息表
 */
@Entity(table=TActivityUserPrivilegeExchange.class)
public class ActivityUserPrivilegeExchange implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;
	private Integer userId;//犇犇号
	private String privilegeCode;//特权码
	private Date privilegeCodeValidTime;//特权码有效时间
	private Integer isActivate;//是否激活[0-否 1-是 2-未知]
	private Date isActivateTime;//激活时间
	private Integer isFreeCommision;//免佣是否生效[0-否 1-是 2-未知]
	private Date isFreeCommisionTime;//免佣生效时间
	private Integer isValidL2Market;//L2行情是否生效[0-否 1-是 2-未知]
	private Date isValidL2MarketTime;//L2行情生效时间
	private String phoneNumber;//手机号码
	private String activitySource;//来源
	private Integer recordStatus = 1;//记录状态[0-无效 1-有效]

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getPrivilegeCode () {
        return privilegeCode;
    }

    public void setPrivilegeCode (String privilegeCode) {
        this.privilegeCode = privilegeCode;
    }

    public Date getPrivilegeCodeValidTime () {
        return privilegeCodeValidTime;
    }

    public void setPrivilegeCodeValidTime (Date privilegeCodeValidTime) {
        this.privilegeCodeValidTime = privilegeCodeValidTime;
    }

    public Integer getIsActivate () {
        return isActivate;
    }

    public void setIsActivate (Integer isActivate) {
        this.isActivate = isActivate;
    }

    public Date getIsActivateTime () {
        return isActivateTime;
    }

    public void setIsActivateTime (Date isActivateTime) {
        this.isActivateTime = isActivateTime;
    }

    public Integer getIsFreeCommision () {
        return isFreeCommision;
    }

    public void setIsFreeCommision (Integer isFreeCommision) {
        this.isFreeCommision = isFreeCommision;
    }

    public Date getIsFreeCommisionTime () {
        return isFreeCommisionTime;
    }

    public void setIsFreeCommisionTime (Date isFreeCommisionTime) {
        this.isFreeCommisionTime = isFreeCommisionTime;
    }

    public Integer getIsValidL2Market () {
        return isValidL2Market;
    }

    public void setIsValidL2Market (Integer isValidL2Market) {
        this.isValidL2Market = isValidL2Market;
    }

    public Date getIsValidL2MarketTime () {
        return isValidL2MarketTime;
    }

    public void setIsValidL2MarketTime (Date isValidL2MarketTime) {
        this.isValidL2MarketTime = isValidL2MarketTime;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getActivitySource () {
        return activitySource;
    }

    public void setActivitySource (String activitySource) {
        this.activitySource = activitySource;
    }

    public Integer getRecordStatus () {
        return recordStatus;
    }

    public void setRecordStatus (Integer recordStatus) {
        this.recordStatus = recordStatus;
    }
}