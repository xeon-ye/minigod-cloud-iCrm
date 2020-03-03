package com.minigod.persist.po;
import com.minigod.persist.tables.TUserInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
@Entity(table=TUserInfo.class)
public class UserInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer userId;//用户ID
	private String nickName;
	private String signature;
	private Boolean gender;//用户性别(1男，0女)
	private String userIcon;//用户图像
	private String userSourceChannelId;//渠道id
	private Integer invUserId;//推荐人ID,邀请该用户的用户ID
	private Integer vocationId;//职业
	private Integer userType = 1;//用户类型(默认所有用户均为1类型;0：游客用户；1：普通用户；2：认证投顾，表示已经审核通过的投顾用户；3:官方账号；)
	private Integer adviserType;//投顾类型
	private Integer userStatus = 1;//用户状态 0-停用,1-正常,2-锁定
	private String password;
	private String privacy = "YYYYY";//隐私开关设置  每一位都用Y/N表示是否开通：第1位：是否允许将我引荐给别人 第2位：是否允许通过手机号搜索到我（控制手机号搜索、通讯录匹配）  第3位：是否接收资讯推送 第4位：加我为联系人时需要验证 第5位:是否开启自选股排序
	private Integer friendLimit = 5000;//好友数量上限默认5000个
	private Integer adviserLimit = 5;//投顾数量上限默认5个
	private Integer ptfFavLimit = 100;//关注组合上限
	private Integer groupLimit = 5;//群组的上限
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间
	private Date lastLoginTime;//最后登录时间
	private String lastLoginIp;
	private Integer lastCityId;//最后登录的城市ID
	private Long loginCount = 0l;//总登录次数
	private String imId;//第三方IM平台的ID
	private String imPwd;//第三方IM平台的密码
	private Integer pwdErrorCount = 0;//密码错误次数
	private Date lockTime;//用户密码锁定的时间
	private Integer lockVersion = 0;//乐观锁版本号
	private String tradePwd;//支付交易密码
	private Integer tradePwdErrCount = 0;//支付密码错误次数
	private String cellPhone;//手机号
	private String areaCode;//国际区号
	private Boolean jfGroup;//玖富集团用户
	private String gesturePwd;//手势密码
	private Integer getstureShowTime;//从后台切换到前台需要输入手势密码的时长限制
	private String regSourceType;//注册来源
	private String regSource;//渠道

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getNickName () {
        return nickName;
    }

    public void setNickName (String nickName) {
        this.nickName = nickName;
    }

    public String getSignature () {
        return signature;
    }

    public void setSignature (String signature) {
        this.signature = signature;
    }

    public Boolean getGender () {
        return gender;
    }

    public void setGender (Boolean gender) {
        this.gender = gender;
    }

    public String getUserIcon () {
        return userIcon;
    }

    public void setUserIcon (String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserSourceChannelId () {
        return userSourceChannelId;
    }

    public void setUserSourceChannelId (String userSourceChannelId) {
        this.userSourceChannelId = userSourceChannelId;
    }

    public Integer getInvUserId () {
        return invUserId;
    }

    public void setInvUserId (Integer invUserId) {
        this.invUserId = invUserId;
    }

    public Integer getVocationId () {
        return vocationId;
    }

    public void setVocationId (Integer vocationId) {
        this.vocationId = vocationId;
    }

    public Integer getUserType () {
        return userType;
    }

    public void setUserType (Integer userType) {
        this.userType = userType;
    }

    public Integer getAdviserType () {
        return adviserType;
    }

    public void setAdviserType (Integer adviserType) {
        this.adviserType = adviserType;
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

    public String getPrivacy () {
        return privacy;
    }

    public void setPrivacy (String privacy) {
        this.privacy = privacy;
    }

    public Integer getFriendLimit () {
        return friendLimit;
    }

    public void setFriendLimit (Integer friendLimit) {
        this.friendLimit = friendLimit;
    }

    public Integer getAdviserLimit () {
        return adviserLimit;
    }

    public void setAdviserLimit (Integer adviserLimit) {
        this.adviserLimit = adviserLimit;
    }

    public Integer getPtfFavLimit () {
        return ptfFavLimit;
    }

    public void setPtfFavLimit (Integer ptfFavLimit) {
        this.ptfFavLimit = ptfFavLimit;
    }

    public Integer getGroupLimit () {
        return groupLimit;
    }

    public void setGroupLimit (Integer groupLimit) {
        this.groupLimit = groupLimit;
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

    public Date getLastLoginTime () {
        return lastLoginTime;
    }

    public void setLastLoginTime (Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp () {
        return lastLoginIp;
    }

    public void setLastLoginIp (String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Integer getLastCityId () {
        return lastCityId;
    }

    public void setLastCityId (Integer lastCityId) {
        this.lastCityId = lastCityId;
    }

    public Long getLoginCount () {
        return loginCount;
    }

    public void setLoginCount (Long loginCount) {
        this.loginCount = loginCount;
    }

    public String getImId () {
        return imId;
    }

    public void setImId (String imId) {
        this.imId = imId;
    }

    public String getImPwd () {
        return imPwd;
    }

    public void setImPwd (String imPwd) {
        this.imPwd = imPwd;
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

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public String getTradePwd () {
        return tradePwd;
    }

    public void setTradePwd (String tradePwd) {
        this.tradePwd = tradePwd;
    }

    public Integer getTradePwdErrCount () {
        return tradePwdErrCount;
    }

    public void setTradePwdErrCount (Integer tradePwdErrCount) {
        this.tradePwdErrCount = tradePwdErrCount;
    }

    public String getCellPhone () {
        return cellPhone;
    }

    public void setCellPhone (String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAreaCode () {
        return areaCode;
    }

    public void setAreaCode (String areaCode) {
        this.areaCode = areaCode;
    }

    public Boolean getJfGroup () {
        return jfGroup;
    }

    public void setJfGroup (Boolean jfGroup) {
        this.jfGroup = jfGroup;
    }

    public String getGesturePwd () {
        return gesturePwd;
    }

    public void setGesturePwd (String gesturePwd) {
        this.gesturePwd = gesturePwd;
    }

    public Integer getGetstureShowTime () {
        return getstureShowTime;
    }

    public void setGetstureShowTime (Integer getstureShowTime) {
        this.getstureShowTime = getstureShowTime;
    }

    public String getRegSourceType () {
        return regSourceType;
    }

    public void setRegSourceType (String regSourceType) {
        this.regSourceType = regSourceType;
    }

    public String getRegSource () {
        return regSource;
    }

    public void setRegSource (String regSource) {
        this.regSource = regSource;
    }
}