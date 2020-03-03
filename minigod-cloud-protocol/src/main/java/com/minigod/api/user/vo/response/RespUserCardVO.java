package com.minigod.api.user.vo.response;

import java.io.Serializable;

import com.minigod.api.user.vo.response.UserTailVO.InvestAbilityVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class RespUserCardVO implements Serializable {

	private static final long serialVersionUID = 3176672955281189535L;

	@TransferID
	private Long userId;//用户ID
	private Integer userCode;//用户ID
	@Emoji
	private String nickname;//用户昵称
	private String userIcon;//头像绝对地址

	@Emoji
	private String sig;//个性签名
	private Integer ptfCnt;//组合数量
	private String maxPer;//最高收益 
	private Integer uType;//用户类型(默认所有用户均为1类型;1：普通用户；2：认证投顾，表示已经审核通过的投顾用户；)
	private Integer gender;//用户性别(1男，0女)
	@Emoji
	private String orgName;//所属投顾机构名称
	@Emoji
	private String orgDesc;//所属机构简介
	private Integer adviserType;//投顾类型
	private String adviserName;//投顾职称
	
	private String[] specialFields;// 擅长领域
	private InvestAbilityVO investAbility;// 投资能力
	private String presentation;//一句话介绍

	public Integer getUserCode() {
		return userCode;
	}

	public void setUserCode(Integer userCode) {
		this.userCode = userCode;
	}

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

	public String getSig() {
		return sig;
	}

	public void setSig(String sig) {
		this.sig = sig;
	}

	public Integer getPtfCnt() {
		return ptfCnt;
	}

	public void setPtfCnt(Integer ptfCnt) {
		this.ptfCnt = ptfCnt;
	}

	public String getMaxPer() {
		return maxPer;
	}

	public void setMaxPer(String maxPer) {
		this.maxPer = maxPer;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgDesc() {
		return orgDesc;
	}

	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}

	public String[] getSpecialFields() {
		return specialFields;
	}

	public void setSpecialFields(String[] specialFields) {
		this.specialFields = specialFields;
	}

	public InvestAbilityVO getInvestAbility() {
		return investAbility;
	}

	public void setInvestAbility(InvestAbilityVO investAbility) {
		this.investAbility = investAbility;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	
	
}
