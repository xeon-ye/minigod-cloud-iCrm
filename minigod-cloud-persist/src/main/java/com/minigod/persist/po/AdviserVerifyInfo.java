package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserVerifyInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 投顾认证信息表
 */
@Entity(table=TAdviserVerifyInfo.class)
public class AdviserVerifyInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer adviserVerId;
	private Integer userId;//用户ID
	private String nickName;//认证昵称
	private String realName;//真实姓名
	private Integer idType;//证件类型(0-身份证)
	private String idNumber;//证件号码
	private Integer adviserType;//投顾类型(1-投资顾问,2-分析师,3-投资达人,4-投资达人基金执业资格,5-投资达人一般证券业务,6-投资达人证券经纪人,7-投资达人证券 经纪业务营销,8-投资达人证券投资咨询业务)
	private String licenceCode;//执业编号
	private Integer cityId;//所属城市ID
	private Integer adviserOrgId;//所属投顾机构ID
	private String dept;//所属营业部
	private String description;//简介
	private String verifyImgs;//认证图片
	private String certUrls;//资质证明照片
	private String certText;//资质证明资料
	private Integer jobStartYear;//从业开始年份
	private String adeptField;//擅长领域
	private Boolean isStatus;//审核状态(0：认证取消;1：认证通过)
	private Integer auditOpr;//审核人id
	private Date verifyTime;//首次审核通过时间
	private Integer lockVersion = 0;//乐观锁
	private String switchVal = "NY";//开关设置  每一位都用Y/N表示是否开通：第1位：是否开启开户服务 默认值N ，第2位：是否开启问答 默认值Y
	private String bdAttributed;//引荐人姓名
	private String reqSrc;//GA为投顾大赛
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private String spellingAbbr;//拼音简称
	private String presentation;//一句话介绍

    public Integer getAdviserVerId () {
        return adviserVerId;
    }

    public void setAdviserVerId (Integer adviserVerId) {
        this.adviserVerId = adviserVerId;
    }

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

    public String getRealName () {
        return realName;
    }

    public void setRealName (String realName) {
        this.realName = realName;
    }

    public Integer getIdType () {
        return idType;
    }

    public void setIdType (Integer idType) {
        this.idType = idType;
    }

    public String getIdNumber () {
        return idNumber;
    }

    public void setIdNumber (String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getAdviserType () {
        return adviserType;
    }

    public void setAdviserType (Integer adviserType) {
        this.adviserType = adviserType;
    }

    public String getLicenceCode () {
        return licenceCode;
    }

    public void setLicenceCode (String licenceCode) {
        this.licenceCode = licenceCode;
    }

    public Integer getCityId () {
        return cityId;
    }

    public void setCityId (Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAdviserOrgId () {
        return adviserOrgId;
    }

    public void setAdviserOrgId (Integer adviserOrgId) {
        this.adviserOrgId = adviserOrgId;
    }

    public String getDept () {
        return dept;
    }

    public void setDept (String dept) {
        this.dept = dept;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getVerifyImgs () {
        return verifyImgs;
    }

    public void setVerifyImgs (String verifyImgs) {
        this.verifyImgs = verifyImgs;
    }

    public String getCertUrls () {
        return certUrls;
    }

    public void setCertUrls (String certUrls) {
        this.certUrls = certUrls;
    }

    public String getCertText () {
        return certText;
    }

    public void setCertText (String certText) {
        this.certText = certText;
    }

    public Integer getJobStartYear () {
        return jobStartYear;
    }

    public void setJobStartYear (Integer jobStartYear) {
        this.jobStartYear = jobStartYear;
    }

    public String getAdeptField () {
        return adeptField;
    }

    public void setAdeptField (String adeptField) {
        this.adeptField = adeptField;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Integer getAuditOpr () {
        return auditOpr;
    }

    public void setAuditOpr (Integer auditOpr) {
        this.auditOpr = auditOpr;
    }

    public Date getVerifyTime () {
        return verifyTime;
    }

    public void setVerifyTime (Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public String getSwitchVal () {
        return switchVal;
    }

    public void setSwitchVal (String switchVal) {
        this.switchVal = switchVal;
    }

    public String getBdAttributed () {
        return bdAttributed;
    }

    public void setBdAttributed (String bdAttributed) {
        this.bdAttributed = bdAttributed;
    }

    public String getReqSrc () {
        return reqSrc;
    }

    public void setReqSrc (String reqSrc) {
        this.reqSrc = reqSrc;
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

    public String getSpellingAbbr () {
        return spellingAbbr;
    }

    public void setSpellingAbbr (String spellingAbbr) {
        this.spellingAbbr = spellingAbbr;
    }

    public String getPresentation () {
        return presentation;
    }

    public void setPresentation (String presentation) {
        this.presentation = presentation;
    }
}