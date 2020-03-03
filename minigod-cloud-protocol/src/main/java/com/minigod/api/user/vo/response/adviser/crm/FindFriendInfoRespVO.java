package com.minigod.api.user.vo.response.adviser.crm;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class FindFriendInfoRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@TransferID
	private Long userId;
	@Emoji
	private String nickname;
	private String userIcon;
	private Integer uType;
	private String imId;
	@Emoji
	private String cmnt;
	private Integer groupId;
	@Emoji
	private String groupName;
	private String assetSize;
	private String investType;
	private String openType;
	private String listenHabits;
	private String gender;
	private String ageRange;
	private String isMarried;
	private String haveChild;
	private String jobHour;
	private String houseType;
	private String carType;
	private String profession;
	private String comment;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public Integer getuType() {
		return uType;
	}
	public void setuType(Integer uType) {
		this.uType = uType;
	}
	public String getImId() {
		return imId;
	}
	public void setImId(String imId) {
		this.imId = imId;
	}
	public String getCmnt() {
		return cmnt;
	}
	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
