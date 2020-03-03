package com.minigod.api.user.vo.response.adviser;

import java.io.Serializable;

/**
 * @Title: RespAdviserVerify.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-14 上午8:46:50
 * @version v1.0
 */

public class RespAdviserVerify implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;

	private Integer isStatus;//0：待审核（审核中）1：审核通过 2：审核不通过  3：未认证（从未提交过申请）

	private String nickName;//认证昵称
	private String realName;//真实姓名

	private Integer idType;//证件类型(0-身份证)
	private String idNumber;//证件号码
	private String licenceCode;//执业编号
	private Integer cityId;//所属城市ID
	private Integer oId;//所属投顾机构ID

	private Integer oType;//投顾机构的名称,1： 表示证券公司	2： 表示证券投资咨询机构

	private String orgName;//投顾机构的名称

	private String dept;//所属营业部
	private String description;//简介

	private String[] certImgs;//认证照片

	private String msg;//认证结果消息
	private Integer adviserType;//认证类型
	private String adviserName;//认证名称
	private String[] certUrls;//资质证明图像
	private String certText;//资质证明资料
	private Integer jobStartYear;//从业开始年份
	private String[] adeptField;//擅长领域

	public Integer getAdviserType() {
		return adviserType;
	}

	public void setAdviserType(Integer adviserType) {
		this.adviserType = adviserType;
	}

	public String getAdviserName() {
		return adviserName;
	}

	public void setAdviserName(String adviserName) {
		this.adviserName = adviserName;
	}

	public String[] getCertUrls() {
		return certUrls;
	}

	public void setCertUrls(String[] certUrls) {
		this.certUrls = certUrls;
	}

	public String getCertText() {
		return certText;
	}

	public void setCertText(String certText) {
		this.certText = certText;
	}

	public Integer getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(Integer isStatus) {
		this.isStatus = isStatus;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getLicenceCode() {
		return licenceCode;
	}

	public void setLicenceCode(String licenceCode) {
		this.licenceCode = licenceCode;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String[] getCertImgs() {
		return certImgs;
	}

	public void setCertImgs(String[] certImgs) {
		this.certImgs = certImgs;
	}

	public Integer getoType() {
		return oType;
	}

	public void setoType(Integer oType) {
		this.oType = oType;
	}

	public Integer getJobStartYear() {
		return jobStartYear;
	}

	public void setJobStartYear(Integer jobStartYear) {
		this.jobStartYear = jobStartYear;
	}

	public String[] getAdeptField() {
		return adeptField;
	}

	public void setAdeptField(String[] adeptField) {
		this.adeptField = adeptField;
	}
}
