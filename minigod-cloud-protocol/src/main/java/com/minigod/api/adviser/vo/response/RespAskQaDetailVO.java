/*
 * FileName: RespAskQaDetailVO.java
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
 * @description 提问者的问答详情
 * 
 * @author panlz
 * @date 2015-11-10 下午3:56:40
 * @version v1.0
 */
@TransferBean
public class RespAskQaDetailVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer qId; // 问题id
	@TransferID
	private Long qUId; // 提问用户id
	private String qName; // 提问用户昵称
	private String qIcon; // 提问用户头像
	private Integer qType; // 问题类型 1股票，2大盘，3其它
	private String assetId; // 资产ID
	private Integer sType; //股票类别
	private String assetName; // 资产名称
	@Emoji
	private String qContent; // 提问内容
	private Integer qStatus; // 问题状态 0接单中 1暂未回答 2已回答

	private Long qTime; // 提问时间
	private String price; // 成本价
	private String position; // 仓位

	@TransferID
	@Emoji
	private AdviserDetail adviser; // 投顾对象
	@TransferID
	@Emoji
	private List<AnsDetail> ans; // 答案内容对象集

	public Integer getqId() {
		return qId;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
	}

	public Long getqUId() {
		return qUId;
	}

	public void setqUId(Long qUId) {
		this.qUId = qUId;
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

	public AdviserDetail getAdviser() {
		return adviser;
	}

	public void setAdviser(AdviserDetail adviser) {
		this.adviser = adviser;
	}

	public List<AnsDetail> getAns() {
		return ans;
	}

	public void setAns(List<AnsDetail> ans) {
		this.ans = ans;
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

	@TransferBean
	public static class AdviserDetail implements Serializable {
		private static final long serialVersionUID = 1L;

		@TransferID
		private Long uId; // 回答者用户id
		private Integer uType; // 0游客 1普通用户 2 投顾
		@Emoji
		private String aName; // 回答者名称
		private String aIcon; // 回答者头像
		private String adviserName; // 投资顾问
		private String orgName; // 所属机构名称
		private String[] adeptField; // 擅长领域

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

		public String[] getAdeptField() {
			return adeptField;
		}

		public void setAdeptField(String[] adeptField) {
			this.adeptField = adeptField;
		}
		
	}

	@TransferBean
	public static class AnsDetail implements Serializable {
		private static final long serialVersionUID = 1L;

		private Integer aId; // 答案id
		@TransferID
		private Long uId; // 回答者用户id
		private Integer uType; // 0游客 1普通用户 2 投顾
		@Emoji
		private String aName; // 回答者名称
		private String aIcon; // 回答者头像
		private String adviserName; // 投资顾问
		private String orgName; // 所属机构名称
		private String[] adeptField; // 擅长领域
		@Emoji
		private String aContent; // 回答内容
		private Long aTime; // 回答时间
		private Integer isSatisfy; // 评价，0不满意 1满意
		private Integer isAdviser; //是否投顾关系 0不是 1是

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

		public String[] getAdeptField() {
			return adeptField;
		}

		public void setAdeptField(String[] adeptField) {
			this.adeptField = adeptField;
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

		public Integer getIsSatisfy() {
			return isSatisfy;
		}

		public void setIsSatisfy(Integer isSatisfy) {
			this.isSatisfy = isSatisfy;
		}

		public Integer getIsAdviser() {
			return isAdviser;
		}

		public void setIsAdviser(Integer isAdviser) {
			this.isAdviser = isAdviser;
		}
	}

}
