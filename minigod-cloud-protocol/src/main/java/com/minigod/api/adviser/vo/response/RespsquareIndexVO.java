/*
 * FileName: RespsquareIndexVO.java
 * Copyright: Copyright 2014-12-5 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.adviser.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.adviser.vo.response.ViewpointSelectionRespVO.ViewpointSelectionRespVO_data;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 
 * @description 广场问答首页
 * 
 * @author panlz
 * @date 2015-11-4 下午3:56:40
 * @version v1.0
 */
@TransferBean
public class RespsquareIndexVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer onlineNum; // 投顾在线人数
	private Long total; // 累计解答总数
	private String nightTime; // 夜间时段(24:00-07:00)
	private Long enterNum; // 入驻投顾总数
	private Long viewPointNum; // 发布观点总数
	private Long ptfNum; // 组合总数

	@TransferID
	@Emoji
	private List<SquareIndexAnswer> ans;
	@TransferID
	@Emoji
	private List<ViewpointSelectionRespVO_data> view;

	private List<PtfMaxRankingSummary> ptfRank;
	@TransferID
	@Emoji
	private List<NiuRecommend> niuRcmd;

	public Integer getOnlineNum() {
		return onlineNum;
	}

	public void setOnlineNum(Integer onlineNum) {
		this.onlineNum = onlineNum;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getNightTime() {
		return nightTime;
	}

	public void setNightTime(String nightTime) {
		this.nightTime = nightTime;
	}

	public Long getEnterNum() {
		return enterNum;
	}

	public void setEnterNum(Long enterNum) {
		this.enterNum = enterNum;
	}

	public Long getViewPointNum() {
		return viewPointNum;
	}

	public void setViewPointNum(Long viewPointNum) {
		this.viewPointNum = viewPointNum;
	}

	public Long getPtfNum() {
		return ptfNum;
	}

	public void setPtfNum(Long ptfNum) {
		this.ptfNum = ptfNum;
	}

	public List<SquareIndexAnswer> getAns() {
		return ans;
	}

	public void setAns(List<SquareIndexAnswer> ans) {
		this.ans = ans;
	}

	public List<ViewpointSelectionRespVO_data> getView() {
		return view;
	}

	public void setView(List<ViewpointSelectionRespVO_data> view) {
		this.view = view;
	}

	public List<PtfMaxRankingSummary> getPtfRank() {
		return ptfRank;
	}

	public void setPtfRank(List<PtfMaxRankingSummary> ptfRank) {
		this.ptfRank = ptfRank;
	}

	public List<NiuRecommend> getNiuRcmd() {
		return niuRcmd;
	}

	public void setNiuRcmd(List<NiuRecommend> niuRcmd) {
		this.niuRcmd = niuRcmd;
	}

	@TransferBean
	public static class SquareIndexAnswer implements Serializable {
		private static final long serialVersionUID = 1L;

		private Integer qId; // 问题id
		private Integer qType; // 问题类型 1股票，2大盘，3其它
		private String dispName; // 显示名称，关于XX的问题
		private String qContent; // 问题内容
		private String assetName; // 资产名称
		private Integer aId; // 答案id
		@TransferID
		private Long uId; // 回答者用户id
		private Integer uType; // 回答者用户id
		@Emoji
		private String aName; // 回答者名称
		private String aIcon; // 回答者头像
		private String orgName; // 机构名称
		private String adviserName; // 投资顾问
		@Emoji
		private String aContent; // 回答内容
		private Long aTime; // 回答时间

		public Integer getqId() {
			return qId;
		}

		public void setqId(Integer qId) {
			this.qId = qId;
		}

		public Integer getqType() {
			return qType;
		}

		public void setqType(Integer qType) {
			this.qType = qType;
		}

		public String getDispName() {
			return dispName;
		}

		public void setDispName(String dispName) {
			this.dispName = dispName;
		}

		public String getqContent() {
			return qContent;
		}

		public void setqContent(String qContent) {
			this.qContent = qContent;
		}

		public String getAssetName() {
			return assetName;
		}

		public void setAssetName(String assetName) {
			this.assetName = assetName;
		}

		public Integer getaId() {
			return aId;
		}

		public void setaId(Integer aId) {
			this.aId = aId;
		}

		public Long getuId() {
			return uId;
		}

		public void setuId(Long uId) {
			this.uId = uId;
		}

		public Integer getuType() {
			return uType;
		}

		public void setuType(Integer uType) {
			this.uType = uType;
		}

		public String getaName() {
			return aName;
		}

		public void setaName(String aName) {
			this.aName = aName;
		}

		public String getaIcon() {
			return aIcon;
		}

		public void setaIcon(String aIcon) {
			this.aIcon = aIcon;
		}

		public String getOrgName() {
			return orgName;
		}

		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}

		public String getAdviserName() {
			return adviserName;
		}

		public void setAdviserName(String adviserName) {
			this.adviserName = adviserName;
		}

		public String getaContent() {
			return aContent;
		}

		public void setaContent(String aContent) {
			this.aContent = aContent;
		}

		public Long getaTime() {
			return aTime;
		}

		public void setaTime(Long aTime) {
			this.aTime = aTime;
		}

	}

	public static class PtfMaxRankingSummary implements Serializable {
		private static final long serialVersionUID = 1L;
		private String type; // 类型R 最近调仓 G 最赚钱组合 H 最稳健组合 I 常胜组合
		private String title;// 如最赚钱、最稳健
		private String desc;// 内容

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	@TransferBean
	public static class NiuRecommend implements Serializable {
		private static final long serialVersionUID = 1L;
		@TransferID
		private Long uId; // 回答者用户id
		private Integer uType; // 用户类型
		@Emoji
		private String uName; // 昵称
		private String uImg; // 头像
		private String adviserName; // 投资顾问
		private String orgName; // 机构名称
		@Emoji
		private String rcmdDesc; // 推荐描述
		private String isAttentioned;//关注状态
		private String presentation;// 一句话介绍

		public Long getuId() {
			return uId;
		}

		public void setuId(Long uId) {
			this.uId = uId;
		}

		public Integer getuType() {
			return uType;
		}

		public void setuType(Integer uType) {
			this.uType = uType;
		}

		public String getuName() {
			return uName;
		}

		public void setuName(String uName) {
			this.uName = uName;
		}

		public String getuImg() {
			return uImg;
		}

		public void setuImg(String uImg) {
			this.uImg = uImg;
		}

		public String getAdviserName() {
			return adviserName;
		}

		public void setAdviserName(String adviserName) {
			this.adviserName = adviserName;
		}

		public String getOrgName() {
			return orgName;
		}

		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}

		public String getRcmdDesc() {
			return rcmdDesc;
		}

		public void setRcmdDesc(String rcmdDesc) {
			this.rcmdDesc = rcmdDesc;
		}

		public String getIsAttentioned() {
			return isAttentioned;
		}

		public void setIsAttentioned(String isAttentioned) {
			this.isAttentioned = isAttentioned;
		}

		public String getPresentation() {
			return presentation;
		}

		public void setPresentation(String presentation) {
			this.presentation = presentation;
		}
		
	}


}
