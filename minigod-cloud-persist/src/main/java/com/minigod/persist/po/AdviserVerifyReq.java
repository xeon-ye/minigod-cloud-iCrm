package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserVerifyReq;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 投顾认证请求表
 */
@Entity(table=TAdviserVerifyReq.class)
public class AdviserVerifyReq implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer adviserVerReqId;
	private Integer userId;//用户ID
	private String nickName;
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
	private Integer auditStatus;//审核状态(0：待审核（审核中；1：审核通过；2：审核不通过)
	private String resultImgs;//执业资格验证结果图片
	private String handleResults;//处理结果
	private String notice;//系统消息或通知内容
	private Integer auditOpr;//审核人id
	private String reqSrc;//GA为投顾大赛
	private Integer lockVersion = 0;//乐观锁
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getAdviserVerReqId () {
        return adviserVerReqId;
    }

    public void setAdviserVerReqId (Integer adviserVerReqId) {
        this.adviserVerReqId = adviserVerReqId;
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

    public Integer getAuditStatus () {
        return auditStatus;
    }

    public void setAuditStatus (Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getResultImgs () {
        return resultImgs;
    }

    public void setResultImgs (String resultImgs) {
        this.resultImgs = resultImgs;
    }

    public String getHandleResults () {
        return handleResults;
    }

    public void setHandleResults (String handleResults) {
        this.handleResults = handleResults;
    }

    public String getNotice () {
        return notice;
    }

    public void setNotice (String notice) {
        this.notice = notice;
    }

    public Integer getAuditOpr () {
        return auditOpr;
    }

    public void setAuditOpr (Integer auditOpr) {
        this.auditOpr = auditOpr;
    }

    public String getReqSrc () {
        return reqSrc;
    }

    public void setReqSrc (String reqSrc) {
        this.reqSrc = reqSrc;
    }

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
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