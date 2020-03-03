/*
 * FileName: RespAnswerQaListVO.java
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
 * @description 问答者的回答列表
 * 
 * @author panlz
 * @date 2015-11-12 下午3:56:40
 * @version v1.0
 */
@TransferBean
public class RespAnswerQaListVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer unReadNum ;//未读数
	@TransferID
	@Emoji
	private List<AnswerQaDetail> qa;//回答者问答列表数据集
	
	public Integer getUnReadNum() {
		return unReadNum;
	}

	public void setUnReadNum(Integer unReadNum) {
		this.unReadNum = unReadNum;
	}

	public List<AnswerQaDetail> getQa() {
		return qa;
	}

	public void setQa(List<AnswerQaDetail> qa) {
		this.qa = qa;
	}

	@TransferBean
	public static class AnswerQaDetail implements Serializable {
		private static final long serialVersionUID = 1L;

		private Integer qId; // 问题id
		private Integer qType; // 问题类型 1股票，2大盘，3其它
		private String assetId; // 资产ID
		private Integer sType; // 股票类别
		private String assetName; // 资产名称
		@TransferID
		private Long qUId; // 提问者用户id
		private Integer qGender; // 性别 1男，0女
		@Emoji
		private String qName; // 提问者名称
		private String qIcon; // 提问者头像
		private String qAddr; // 提问者地址
		@Emoji
		private String qContent; // 提问内容
		private Integer qStatus; // 问题状态 0待抢答，1已抢未答，2已回答， 3放弃 ,4超时
		private Long qTime; // 提问时间
		
		private String price; // 成本价
		private String position; // 仓位
		private Long timeLimit;  //回答截止时间
		
		private Integer aId; // 答案id
		@Emoji
		private String aContent; // 回答内容
		private Integer isSatisfy; // 评价，0不满意 1满意
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
		public Long getqUId() {
			return qUId;
		}
		public void setqUId(Long qUId) {
			this.qUId = qUId;
		}
		public Integer getqGender() {
			return qGender;
		}
		public void setqGender(Integer qGender) {
			this.qGender = qGender;
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
		public String getqAddr() {
			return qAddr;
		}
		public void setqAddr(String qAddr) {
			this.qAddr = qAddr;
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
		public Long getTimeLimit() {
			return timeLimit;
		}
		public void setTimeLimit(Long timeLimit) {
			this.timeLimit = timeLimit;
		}
		public Integer getaId() {
			return aId;
		}
		public void setaId(Integer aId) {
			this.aId = aId;
		}
		public String getaContent() {
			return aContent;
		}
		public void setaContent(String aContent) {
			this.aContent = aContent;
		}
		public Integer getIsSatisfy() {
			return isSatisfy;
		}
		public void setIsSatisfy(Integer isSatisfy) {
			this.isSatisfy = isSatisfy;
		}
		public Long getaTime() {
			return aTime;
		}
		public void setaTime(Long aTime) {
			this.aTime = aTime;
		}
	}

}
