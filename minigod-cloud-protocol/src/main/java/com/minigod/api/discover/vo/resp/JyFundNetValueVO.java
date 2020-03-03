/**
 * @Title: JyFundNetVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.discover.vo.resp;

import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-4 下午8:20:36
 * @version v1.0
 */

public class JyFundNetValueVO implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Long id;// 基金净值id
	private Date infoPublDate;// 发布时间
	private Date endDate;// 交易日期
	private Double unitNv; // 单位净值
	private Double accumulatedUnitNv; // 累计净值
	private String assetId;// 资产ID
	private Date xgrq;// 外部的时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInfoPublDate() {
		return infoPublDate;
	}

	public void setInfoPublDate(Date infoPublDate) {
		this.infoPublDate = infoPublDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getUnitNv() {
		return unitNv;
	}

	public void setUnitNv(Double unitNv) {
		this.unitNv = unitNv;
	}

	public Double getAccumulatedUnitNv() {
		return accumulatedUnitNv;
	}

	public void setAccumulatedUnitNv(Double accumulatedUnitNv) {
		this.accumulatedUnitNv = accumulatedUnitNv;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Date getXgrq() {
		return xgrq;
	}

	public void setXgrq(Date xgrq) {
		this.xgrq = xgrq;
	}

}
