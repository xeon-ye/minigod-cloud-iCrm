package com.minigod.api.user.vo.request.adviser.crm;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

@TransferBean
public class SaveFriendInfoReqVO extends SNUserBase {
	private static final long serialVersionUID = 1L;

	@Emoji
	private String cmnt;
	private Long groupId;
	private String assetSize;
	private String investType;
	private String openType;
	private String listenHabits;
	private String ageRange;
	private String isMarried;
	private String haveChild;
	private String jobHour;
	private String houseType;
	private String carType;
	private String profession;
	private String comment; 
	
	public String getCmnt() {
		return cmnt;
	}
	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
