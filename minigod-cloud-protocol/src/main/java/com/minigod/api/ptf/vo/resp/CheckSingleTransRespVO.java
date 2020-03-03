/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2016-2-26 下午1:16:21
 * @version v1.0
 */
@TransferBean
public class CheckSingleTransRespVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double avlBal;// 可用资金
	private String mktOrderDesc; // 市场委托类型描述
	private CheckSingleTransRespStk stk;
	@TransferID
	private CheckSingleTransRespPtf ptf;

	public CheckSingleTransRespStk getStk() {
		return stk;
	}

	public void setStk(CheckSingleTransRespStk stk) {
		this.stk = stk;
	}

	public CheckSingleTransRespPtf getPtf() {
		return ptf;
	}

	public void setPtf(CheckSingleTransRespPtf ptf) {
		this.ptf = ptf;
	}
	@TransferBean
	public static class CheckSingleTransRespPtf implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@TransferID
		private Long ptfId; // 组合ID
		private String isReal; // 是否实盘
		private String name;// 组合名称

		public Long getPtfId() {
			return ptfId;
		}

		public void setPtfId(Long ptfId) {
			this.ptfId = ptfId;
		}

		public String getIsReal() {
			return isReal;
		}

		public void setIsReal(String isReal) {
			this.isReal = isReal;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static class CheckSingleTransRespStk implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private String assetId;// 资产ID
		private Integer stkType;// 证券类别
		private String stkName;// 股票名
		private Double tBal;// 总余额
		private String price;// 现价
		private String holdPrc;// 持仓成本价
		private String buyCalPrc;// 计算最大可买股数用的单股价格
		private Double aBal;// 可用余额
		private Integer status;// 股票状态标示

		public String getAssetId() {
			return assetId;
		}

		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}

		public String getStkName() {
			return stkName;
		}

		public void setStkName(String stkName) {
			this.stkName = stkName;
		}

		public Double gettBal() {
			return tBal;
		}

		public void settBal(Double tBal) {
			this.tBal = tBal;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getBuyCalPrc() {
			return buyCalPrc;
		}

		public void setBuyCalPrc(String buyCalPrc) {
			this.buyCalPrc = buyCalPrc;
		}

		public Double getaBal() {
			return aBal;
		}

		public void setaBal(Double aBal) {
			this.aBal = aBal;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getHoldPrc() {
			return holdPrc;
		}

		public void setHoldPrc(String holdPrc) {
			this.holdPrc = holdPrc;
		}

		public Integer getStkType() {
			return stkType;
		}

		public void setStkType(Integer stkType) {
			this.stkType = stkType;
		}
		

	}

	public Double getAvlBal() {
		return avlBal;
	}

	public void setAvlBal(Double avlBal) {
		this.avlBal = avlBal;
	}

	public String getMktOrderDesc() {
		return mktOrderDesc;
	}

	public void setMktOrderDesc(String mktOrderDesc) {
		this.mktOrderDesc = mktOrderDesc;
	}
	
	

}
