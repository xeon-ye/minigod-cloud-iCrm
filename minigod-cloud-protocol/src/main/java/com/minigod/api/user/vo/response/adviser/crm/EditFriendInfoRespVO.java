package com.minigod.api.user.vo.response.adviser.crm;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class EditFriendInfoRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private Long userId;
	@Emoji
	private String nickname;
	private String userIcon;
	private Integer uType;
	private String imId;
	private String cmnt;
	private String comment;
	@Emoji
	private List<EditFriendInfo_select> group;
	private List<EditFriendInfo_select> assetSize;
	private List<EditFriendInfo_select> investType;
	private List<EditFriendInfo_select> openType;
	private List<EditFriendInfo_select> listenHabits;
	private List<EditFriendInfo_select> gender;
	private List<EditFriendInfo_select> ageRange;
	private List<EditFriendInfo_select> isMarried;
	private List<EditFriendInfo_select> haveChild;
	private List<EditFriendInfo_select> jobHour;
	private List<EditFriendInfo_select> houseType;
	private List<EditFriendInfo_select> carType;
	private List<EditFriendInfo_select> tProfession;
	private List<EditFriendInfo_select> hProfession;
	
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

	public List<EditFriendInfo_select> getGroup() {
		return group;
	}

	public void setGroup(List<EditFriendInfo_select> group) {
		this.group = group;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<EditFriendInfo_select> getAssetSize() {
		return assetSize;
	}

	public void setAssetSize(List<EditFriendInfo_select> assetSize) {
		this.assetSize = assetSize;
	}

	public List<EditFriendInfo_select> getInvestType() {
		return investType;
	}

	public void setInvestType(List<EditFriendInfo_select> investType) {
		this.investType = investType;
	}

	public List<EditFriendInfo_select> getOpenType() {
		return openType;
	}

	public void setOpenType(List<EditFriendInfo_select> openType) {
		this.openType = openType;
	}

	public List<EditFriendInfo_select> getListenHabits() {
		return listenHabits;
	}

	public void setListenHabits(List<EditFriendInfo_select> listenHabits) {
		this.listenHabits = listenHabits;
	}

	public List<EditFriendInfo_select> getGender() {
		return gender;
	}

	public void setGender(List<EditFriendInfo_select> gender) {
		this.gender = gender;
	}

	public List<EditFriendInfo_select> getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(List<EditFriendInfo_select> ageRange) {
		this.ageRange = ageRange;
	}

	public List<EditFriendInfo_select> getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(List<EditFriendInfo_select> isMarried) {
		this.isMarried = isMarried;
	}

	public List<EditFriendInfo_select> getHaveChild() {
		return haveChild;
	}

	public void setHaveChild(List<EditFriendInfo_select> haveChild) {
		this.haveChild = haveChild;
	}

	public List<EditFriendInfo_select> getJobHour() {
		return jobHour;
	}

	public void setJobHour(List<EditFriendInfo_select> jobHour) {
		this.jobHour = jobHour;
	}

	public List<EditFriendInfo_select> getHouseType() {
		return houseType;
	}

	public void setHouseType(List<EditFriendInfo_select> houseType) {
		this.houseType = houseType;
	}

	public List<EditFriendInfo_select> getCarType() {
		return carType;
	}

	public void setCarType(List<EditFriendInfo_select> carType) {
		this.carType = carType;
	}

	public List<EditFriendInfo_select> gettProfession() {
		return tProfession;
	}

	public void settProfession(List<EditFriendInfo_select> tProfession) {
		this.tProfession = tProfession;
	}

	public List<EditFriendInfo_select> gethProfession() {
		return hProfession;
	}

	public void sethProfession(List<EditFriendInfo_select> hProfession) {
		this.hProfession = hProfession;
	}

	@TransferBean
	public static class EditFriendInfo_select implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@Emoji
		private String name;
		private String value;
		private Integer selected;
		private String remark;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Integer getSelected() {
			return selected;
		}
		public void setSelected(Integer selected) {
			this.selected = selected;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
	}
}
