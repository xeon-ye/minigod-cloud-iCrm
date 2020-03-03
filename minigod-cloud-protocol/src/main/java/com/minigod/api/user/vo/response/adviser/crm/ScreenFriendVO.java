package com.minigod.api.user.vo.response.adviser.crm;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 获取筛选的好友
 */
@TransferBean
public class ScreenFriendVO implements Serializable {

	private static final long serialVersionUID = 340831528495266018L;

	@TransferID
	private Long userId;//用户ID

	@Emoji
	private String nickname;//用户昵称
	
	@Emoji
	private String cmnt;//备注名

	private String userIcon;//用户图像
	
	private Integer uType;//用户类型(默认所有用户均为1类型;1：普通用户；2：认证投顾，表示已经审核通过的投顾用户；)
	
	private Integer groupId;//分组id
	
	private Long uTime ;//时间
	
	@Emoji
	private String groupName;//组名
	
	private String imId; //聊天im id
	
	private String assetSize;//资产规模
	
	private String investType;//投资风格
	
	private String ageRange;//年龄范围
	
	private String profession;//职业属性

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

	public String getCmnt() {
		return cmnt;
	}

	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
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

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Long getuTime() {
		return uTime;
	}

	public void setuTime(Long uTime) {
		this.uTime = uTime;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getImId() {
		return imId;
	}

	public void setImId(String imId) {
		this.imId = imId;
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

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

}
