package com.minigod.api.user.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.user.vo.response.UserSummaryVO;
import com.minigod.api.adviser.vo.response.ViewpointListRespVO.ViewpointListRespVO_data;
import com.minigod.api.grm.fc.vo.resp.EF07000001VO;
import com.minigod.api.user.vo.response.adviser.AdviserOpenFuncVO;
import com.minigod.api.user.vo.response.adviser.AdviserVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 用户详情信息
 */

@TransferBean
public class UserTailVO extends UserSummaryVO {

	private static final long serialVersionUID = 4634493797205539684L;

	private Integer gender;// 用户性别(1男，0女)
	private String phoneNum;// 手机号

	@Emoji
	private String profile;// 用户简介

	@Emoji
	private String signature;// 用户签名
	private String bigUserIcon;// 大图像
	private Integer status;// 用户关系
	@Emoji
	private String cmnt;// 备注名
	private Integer uType;// 用户类型(默认所有用户均为1类型;1：普通用户；2：认证投顾，表示已经审核通过的投顾用户；3:官方账号；4:见证人)
	@Emoji
	private AdviserVO adviser;// 投顾认证对象

	@TransferID
	private Long userId;// 用户ID
	private String userCode; //犇犇号
	private Integer invUserId;//推荐人ID,邀请该用户的用户ID
	private String userSourceChannelId;//渠道id
	private String trdAccount; //是否绑定交易帐号
	private String email;
	private String imId; // IM用户

	private String imPwd; // IM密码

	private Integer ptfCnt;// 组合数量
	private String maxPer;// 最高收益

	private String canOpen; // 是否可以开户 Y可以开 N不可以开

	private AdviserOpenFuncVO openFunc; // 投顾开户信息

	private Integer optStkCnt;// 自选股数量
	private Integer investMsgCnt;// 投资圈数量
	private Integer adviserCnt;// 投顾数量
	@TransferID
	@Emoji
	private List<MyAdviserVO> myAdvisers;// 我的投顾列表
	@TransferID
	@Emoji
	private List<UserTailVO> myAdviserExts;// 我的投顾列表
	
	private Integer customerCnt;// 客户数量
	private String[] specialFields;// 擅长领域
	private Integer viewpointUnreadCnt;// 问答记录数
	private Integer qaAllCnt;// 观点记录总数
	private Integer knowDay;// 认识天数
	private Integer relation;// 用户关系
	private InvestAbilityVO investAbility;// 投资能力
	@Emoji
	private ViewpointListRespVO_data latestViewpoint;// 最新观点
	@Emoji
	private AdviserRelationVO adviserCusRelation;// 投顾--客户关系
	private Integer friendCnt;// 好友总数
	private String friendDesc; // 好友描述信息
	private List<String> customerInfo;// 客户问题
	private Integer qaUnreadCnt;// 未读观点记录数
	private EF07000001VO ef07000001VO; //行情信息
	private Integer usAccountState; // 美股账户开通状态
	private Integer derivativeState; // 衍生品开通状态
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getInvUserId() {
		return invUserId;
	}

	public void setInvUserId(Integer invUserId) {
		this.invUserId = invUserId;
	}

	public String getTrdAccount() {
		return trdAccount;
	}

	public void setTrdAccount(String trdAccount) {
		this.trdAccount = trdAccount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public List<UserTailVO> getMyAdviserExts() {
		return myAdviserExts;
	}

	public void setMyAdviserExts(List<UserTailVO> myAdviserExts) {
		this.myAdviserExts = myAdviserExts;
	}

	public Integer getQaUnreadCnt() {
		return qaUnreadCnt;
	}

	public void setQaUnreadCnt(Integer qaUnreadCnt) {
		this.qaUnreadCnt = qaUnreadCnt;
	}

	public List<String> getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(List<String> customerInfo) {
		this.customerInfo = customerInfo;
	}

	public Integer getFriendCnt() {
		return friendCnt;
	}

	public void setFriendCnt(Integer friendCnt) {
		this.friendCnt = friendCnt;
	}


	public String getFriendDesc() {
		return friendDesc;
	}

	public void setFriendDesc(String friendDesc) {
		this.friendDesc = friendDesc;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getImId() {
		return imId;
	}

	public void setImId(String imId) {
		this.imId = imId;
	}

	public String getImPwd() {
		return imPwd;
	}

	public void setImPwd(String imPwd) {
		this.imPwd = imPwd;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getBigUserIcon() {
		return bigUserIcon;
	}

	public void setBigUserIcon(String bigUserIcon) {
		this.bigUserIcon = bigUserIcon;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCmnt() {
		return cmnt;
	}

	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public AdviserVO getAdviser() {
		return adviser;
	}

	public void setAdviser(AdviserVO adviser) {
		this.adviser = adviser;
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

	public String getCanOpen() {
		return canOpen;
	}

	public void setCanOpen(String canOpen) {
		this.canOpen = canOpen;
	}

	public AdviserOpenFuncVO getOpenFunc() {
		return openFunc;
	}

	public void setOpenFunc(AdviserOpenFuncVO openFunc) {
		this.openFunc = openFunc;
	}

	public Integer getOptStkCnt() {
		return optStkCnt;
	}

	public void setOptStkCnt(Integer optStkCnt) {
		this.optStkCnt = optStkCnt;
	}

	public Integer getInvestMsgCnt() {
		return investMsgCnt;
	}

	public void setInvestMsgCnt(Integer investMsgCnt) {
		this.investMsgCnt = investMsgCnt;
	}

	public Integer getAdviserCnt() {
		return adviserCnt;
	}

	public void setAdviserCnt(Integer adviserCnt) {
		this.adviserCnt = adviserCnt;
	}

	public List<MyAdviserVO> getMyAdvisers() {
		return myAdvisers;
	}

	public void setMyAdvisers(List<MyAdviserVO> myAdvisers) {
		this.myAdvisers = myAdvisers;
	}

	public Integer getCustomerCnt() {
		return customerCnt;
	}

	public void setCustomerCnt(Integer customerCnt) {
		this.customerCnt = customerCnt;
	}

	public String[] getSpecialFields() {
		return specialFields;
	}

	public void setSpecialFields(String[] specialFields) {
		this.specialFields = specialFields;
	}

	public Integer getViewpointUnreadCnt() {
		return viewpointUnreadCnt;
	}

	public void setViewpointUnreadCnt(Integer viewpointUnreadCnt) {
		this.viewpointUnreadCnt = viewpointUnreadCnt;
	}

	public Integer getQaAllCnt() {
		return qaAllCnt;
	}

	public void setQaAllCnt(Integer qaAllCnt) {
		this.qaAllCnt = qaAllCnt;
	}

	public Integer getKnowDay() {
		return knowDay;
	}

	public void setKnowDay(Integer knowDay) {
		this.knowDay = knowDay;
	}

	public Integer getRelation() {
		return relation;
	}

	public void setRelation(Integer relation) {
		this.relation = relation;
	}

	public InvestAbilityVO getInvestAbility() {
		return investAbility;
	}

	public void setInvestAbility(InvestAbilityVO investAbility) {
		this.investAbility = investAbility;
	}

	public ViewpointListRespVO_data getLatestViewpoint() {
		return latestViewpoint;
	}

	public void setLatestViewpoint(ViewpointListRespVO_data latestViewpoint) {
		this.latestViewpoint = latestViewpoint;
	}

	public AdviserRelationVO getAdviserCusRelation() {
		return adviserCusRelation;
	}

	public EF07000001VO getEf07000001VO() {
		return ef07000001VO;
	}

	public void setEf07000001VO(EF07000001VO ef07000001VO) {
		this.ef07000001VO = ef07000001VO;
	}

	public String getUserSourceChannelId() {
		return userSourceChannelId;
	}

	public void setUserSourceChannelId(String userSourceChannelId) {
		this.userSourceChannelId = userSourceChannelId;
	}

	public void setAdviserCusRelation(AdviserRelationVO adviserCusRelation) {
		this.adviserCusRelation = adviserCusRelation;
	}

	public Integer getUsAccountState() {
		return usAccountState;
	}

	public void setUsAccountState(Integer usAccountState) {
		this.usAccountState = usAccountState;
	}

	public Integer getDerivativeState() {
		return derivativeState;
	}

	public void setDerivativeState(Integer derivativeState) {
		this.derivativeState = derivativeState;
	}

	public static class InvestAbilityVO implements Serializable {

		private static final long serialVersionUID = 1L;

		private String wYield;
		private String mYield;
		private String yYield;
		private String selWinRate;
		private String selPolicy;
		private String hldDay;
		private String hldPolicy;
		private String retracement;
		private String retracePolicy;

		public String getwYield() {
			return wYield;
		}

		public void setwYield(String wYield) {
			this.wYield = wYield;
		}

		public String getmYield() {
			return mYield;
		}

		public void setmYield(String mYield) {
			this.mYield = mYield;
		}

		public String getyYield() {
			return yYield;
		}

		public void setyYield(String yYield) {
			this.yYield = yYield;
		}

		public String getSelWinRate() {
			return selWinRate;
		}

		public void setSelWinRate(String selWinRate) {
			this.selWinRate = selWinRate;
		}

		public String getSelPolicy() {
			return selPolicy;
		}

		public void setSelPolicy(String selPolicy) {
			this.selPolicy = selPolicy;
		}

		public String getHldDay() {
			return hldDay;
		}

		public void setHldDay(String hldDay) {
			this.hldDay = hldDay;
		}

		public String getHldPolicy() {
			return hldPolicy;
		}

		public void setHldPolicy(String hldPolicy) {
			this.hldPolicy = hldPolicy;
		}

		public String getRetracement() {
			return retracement;
		}

		public void setRetracement(String retracement) {
			this.retracement = retracement;
		}

		public String getRetracePolicy() {
			return retracePolicy;
		}

		public void setRetracePolicy(String retracePolicy) {
			this.retracePolicy = retracePolicy;
		}

	}

	@TransferBean
	public static class AdviserRelationVO implements Serializable {

		private static final long serialVersionUID = 1L;
		private Long date;
		@Emoji
		private List<String> groups;
		@Emoji
		private List<String> ptfs;
		@Emoji
		private String comment;
		private String openType;
		private Integer qaAllCnt;

		public Integer getQaAllCnt() {
			return qaAllCnt;
		}

		public void setQaAllCnt(Integer qaAllCnt) {
			this.qaAllCnt = qaAllCnt;
		}

		public Long getDate() {
			return date;
		}

		public void setDate(Long date) {
			this.date = date;
		}

		public List<String> getGroups() {
			return groups;
		}

		public void setGroups(List<String> groups) {
			this.groups = groups;
		}

		public List<String> getPtfs() {
			return ptfs;
		}

		public void setPtfs(List<String> ptfs) {
			this.ptfs = ptfs;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getOpenType() {
			return openType;
		}

		public void setOpenType(String openType) {
			this.openType = openType;
		}

	}

}
