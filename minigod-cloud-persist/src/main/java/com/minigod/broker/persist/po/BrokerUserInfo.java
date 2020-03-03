package com.minigod.broker.persist.po;
import com.minigod.broker.persist.tables.TBrokerUserInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 经理人信息表
 */
@Entity(table=TBrokerUserInfo.class)
public class BrokerUserInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long brokerId;//主键
	private String userName;//帐户名
	private String userIcon;//用户图像
	private String phoneNum;//手机号
	private Integer userStatus = 1;//用户状态 0-停用,1-正常,2-锁定
	private String password;//密码
	private Boolean isBindWx = false;//是否绑定微信
	private String wxOpenId;//微信openid
	private Integer pwdErrorCount = 0;//密码错误次数
	private Date lockTime;//用户密码锁定的时间
	private Boolean isSign = false;//是否签约经理人
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Long getBrokerId () {
        return brokerId;
    }

    public void setBrokerId (Long brokerId) {
        this.brokerId = brokerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIcon () {
        return userIcon;
    }

    public void setUserIcon (String userIcon) {
        this.userIcon = userIcon;
    }

    public String getPhoneNum () {
        return phoneNum;
    }

    public void setPhoneNum (String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getUserStatus () {
        return userStatus;
    }

    public void setUserStatus (Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public Boolean getIsBindWx () {
        return isBindWx;
    }

    public void setIsBindWx (Boolean isBindWx) {
        this.isBindWx = isBindWx;
    }

    public String getWxOpenId () {
        return wxOpenId;
    }

    public void setWxOpenId (String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public Integer getPwdErrorCount () {
        return pwdErrorCount;
    }

    public void setPwdErrorCount (Integer pwdErrorCount) {
        this.pwdErrorCount = pwdErrorCount;
    }

    public Date getLockTime () {
        return lockTime;
    }

    public void setLockTime (Date lockTime) {
        this.lockTime = lockTime;
    }

    public Boolean getIsSign () {
        return isSign;
    }

    public void setIsSign (Boolean isSign) {
        this.isSign = isSign;
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