package com.minigod.api.user.vo.request.adviser.crm;

import java.io.Serializable;

public class FriendAttribScreen  implements Serializable {

	private static final long serialVersionUID = -4023476842698514503L;

	private Integer groupId ; //分组id
	private String name ; //昵称或者备注
	private String assetSize; //资产规模
	private String investType; //投资风格
	private String openType; //开户信息
	private String listenHabits; //听消息习惯
	private Integer gender; //性别
	private String ageRange; //年龄范围
	private String isMarried; //婚否
	private String haveChild; //有孩子否
	private String jobHour; //工作时长
	private String houseType; //房子
	private String carType; //车子
	private String profession; //职业
	
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAssetSize() {
		return assetSize;
	}
	public void setAssetSize(String assetSize) {
		this.assetSize = assetSize;
	}
	public String getInvestType() {
		return investType;
	}
	public void setInvestType(String investType) {
		this.investType = investType;
	}
	public String getOpenType() {
		return openType;
	}
	public void setOpenType(String openType) {
		this.openType = openType;
	}
	public String getListenHabits() {
		return listenHabits;
	}
	public void setListenHabits(String listenHabits) {
		this.listenHabits = listenHabits;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getAgeRange() {
		return ageRange;
	}
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
	public String getIsMarried() {
		return isMarried;
	}
	public void setIsMarried(String isMarried) {
		this.isMarried = isMarried;
	}
	public String getHaveChild() {
		return haveChild;
	}
	public void setHaveChild(String haveChild) {
		this.haveChild = haveChild;
	}
	public String getJobHour() {
		return jobHour;
	}
	public void setJobHour(String jobHour) {
		this.jobHour = jobHour;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
}
