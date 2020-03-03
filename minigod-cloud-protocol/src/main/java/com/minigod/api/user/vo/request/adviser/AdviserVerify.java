package com.minigod.api.user.vo.request.adviser;

import java.io.Serializable;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @Title: AdviserVerify.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-13 下午5:33:25
 * @version v1.0
 */

public class AdviserVerify extends SNUserBase implements Serializable {

	private static final long serialVersionUID = 2406842815060417640L;

	private String nickName;//认证昵称		
	private String realName;//真实姓名		
	private Integer idType;//认证类型     1：身份证
	private String idNumber;//认证号码	如：身份证号码
	private String licenceCode;//执业编号		
	private Integer oId;//投顾机构ID	
	private Integer cityId;//所属城市ID
	private String dept;//所属营业部;如果是投资咨询机构，不需要填写
	private String description;//简介		
	private String[] certImgs;//认证照片
	private Integer adviserType;//投顾类型
	private String[] certUrls;//资质证明照片
	private String certText;//资质证明资料
	private Integer jobStartYear;//从业开始年份
	private String[] adeptField;//擅长领域

	public String getCertText() {
		return certText;
	}

	public void setCertText(String certText) {
		this.certText = certText;
	}

	public Integer getAdviserType() {
		return adviserType;
	}

	public void setAdviserType(Integer adviserType) {
		this.adviserType = adviserType;
	}

	public String[] getCertUrls() {
		return certUrls;
	}

	public void setCertUrls(String[] certUrls) {
		this.certUrls = certUrls;
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

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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

	public String[] getCertImgs() {
		return certImgs;
	}

	public void setCertImgs(String[] certImgs) {
		this.certImgs = certImgs;
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
