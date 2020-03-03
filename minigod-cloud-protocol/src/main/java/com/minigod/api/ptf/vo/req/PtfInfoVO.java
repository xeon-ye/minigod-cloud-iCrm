/*
 * FileName: PtfInfoVO.java
 * Copyright: Copyright 2014-10-23 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.vo.BaseVO;

/**
 * <code>PtfInfoVO<code> 创建组合（保存基本信息、比例、选股、权限）时，前端传递过来的参数。
 * 
 * @author Jimmy
 * @since MiniGod v0.0.1 (2014-10-23)
 * 
 */

public class PtfInfoVO extends BaseVO {

	private static final long serialVersionUID = 3176795177961464772L;

	/** 组合的名字 */
	private String name;
	/** 组合的描述 */
	private String desc;
	/** 组合图片的 URL */
	private String imgUrl;
	/** 组合的权限 */
	private Integer perm;
	/** 组合的所有的资产的占比 */
	private List<StockQty> stks;
	/** 部分好友可见时的好友id列表 */
	private List<Integer> uIds;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getPerm() {
		return perm;
	}

	public void setPerm(Integer perm) {
		this.perm = perm;
	}

	public List<StockQty> getStks() {
		return stks;
	}

	public void setStks(List<StockQty> stks) {
		this.stks = stks;
	}

	public List<Integer> getuIds() {
		return uIds;
	}

	public void setuIds(List<Integer> uIds) {
		this.uIds = uIds;
	}

	/**
	 * <code>StockRatio<code> 股票占比映射类。
	 */
	public static class StockQty implements Serializable {
		private static final long serialVersionUID = 8735199408040241208L;
		/** 资产ID */
		private String assetId;
		/** 股数 */
		private Double qty;

		public StockQty() {
		}

		public StockQty(String assetId, Double qty) {
			super();
			this.assetId = assetId;
			this.qty = qty;
		}

		public String getAssetId() {
			return assetId;
		}

		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}

		public Double getQty() {
			return qty;
		}

		public void setQty(Double qty) {
			this.qty = qty;
		}

	}

}
