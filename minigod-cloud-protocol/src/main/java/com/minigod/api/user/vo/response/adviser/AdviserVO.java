package com.minigod.api.user.vo.response.adviser;
import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * 投顾认证信息对象返回
 */
@TransferBean
public class AdviserVO implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	@Emoji
	private String nickName;//投顾认证昵称
	@Emoji
	private String realName;//真实姓名
	private String licCode;//执业编号
	private Integer cityId;//所属城市ID
	private Integer oId;//所属投顾机构ID
	@Emoji
	private String orgName;//所属投顾机构名称
	@Emoji
	private String dept;//所属营业部
	@Emoji
	private String desc;//认证信息
	private Integer adviserType;//认证类型
	private String adviserName;//认证名称
	private String year; //从业年限
	private String attentionedCount; //关注人数
	private String presentation;// 一句话介绍
	
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
	public String getLicCode() {
		return licCode;
	}
	public void setLicCode(String licCode) {
		this.licCode = licCode;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAttentionedCount() {
		return attentionedCount;
	}
	public void setAttentionedCount(String attentionedCount) {
		this.attentionedCount = attentionedCount;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

}