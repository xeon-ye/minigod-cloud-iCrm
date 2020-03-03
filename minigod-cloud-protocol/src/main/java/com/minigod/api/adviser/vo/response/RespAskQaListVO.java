/*
 * FileName: RespAskQaListVO.java
 * Copyright: Copyright 2014-12-5 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.adviser.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 
 * @description 提问者的回答列表
 *
 * @author panlz
 * @date 2015-11-4 下午3:56:40
 * @version v1.0
 */
@TransferBean
public class RespAskQaListVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer unReadNum ;//未读数
	@TransferID
	@Emoji
	private List<AskQa> qa;
	
	public Integer getUnReadNum() {
		return unReadNum;
	}

	public void setUnReadNum(Integer unReadNum) {
		this.unReadNum = unReadNum;
	}

	public List<AskQa> getQa() {
		return qa;
	}

	public void setQa(List<AskQa> qa) {
		this.qa = qa;
	}

	@TransferBean
	public static class AskQa implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private Integer qId; //问题id
		private Integer qType; //问题类型 1股票，2大盘，3其它
		private String assetId; //资产ID
		private Integer sType; //股票类别
		private String assetName; //资产名称
		@Emoji
		private String qContent; //提问内容
		private Integer qStatus; //问题状态 0接单中 1暂未回答 2已回答
		private Long qTime; //提问时间
		private Integer isSatisfy; //评价，0不满意 1满意
		private Integer aId; //答案id
		@TransferID
		private Long qUid; //提问者id
		private String qName; //提问者id
		private String qIcon; //提问者id
		@TransferID
		private Long uId; //回答者用户id
		private Integer uType; //0游客 1普通用户 2 投顾
		@Emoji
		private String aName; //回答者名称
		private String aIcon; //回答者头像
		private String adviserName; //投资顾问
		private String orgName; //所属机构名称
		@Emoji
		private String aContent; //回答内容
		private Long aTime; //回答时间
		private Integer isAdviser; //是否投顾关系 0不是 1是
		private String price; //成本价
		private String position; //仓位
		
		
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
		public String getAssetId() {
			return assetId;
		}
		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}
		public Integer getsType() {
			return sType;
		}
		public void setsType(Integer sType) {
			this.sType = sType;
		}
		public String getAssetName() {
			return assetName;
		}
		public void setAssetName(String assetName) {
			this.assetName = assetName;
		}
		public String getqContent() {
			return qContent;
		}
		public void setqContent(String qContent) {
			this.qContent = qContent;
		}
		public Integer getqStatus() {
			return qStatus;
		}
		public void setqStatus(Integer qStatus) {
			this.qStatus = qStatus;
		}
		public Long getqTime() {
			return qTime;
		}
		public void setqTime(Long qTime) {
			this.qTime = qTime;
		}
		public Integer getIsSatisfy() {
			return isSatisfy;
		}
		public void setIsSatisfy(Integer isSatisfy) {
			this.isSatisfy = isSatisfy;
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
		public Integer getIsAdviser() {
			return isAdviser;
		}
		public void setIsAdviser(Integer isAdviser) {
			this.isAdviser = isAdviser;
		}
		public Long getqUid() {
			return qUid;
		}
		public void setqUid(Long qUid) {
			this.qUid = qUid;
		}
		public String getqName() {
			return qName;
		}
		public void setqName(String qName) {
			this.qName = qName;
		}
		public String getqIcon() {
			return qIcon;
		}
		public void setqIcon(String qIcon) {
			this.qIcon = qIcon;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		
	}
}
