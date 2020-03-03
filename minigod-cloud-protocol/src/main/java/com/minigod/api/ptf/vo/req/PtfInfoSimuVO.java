/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/
package com.minigod.api.ptf.vo.req;

import java.util.List;

import com.minigod.api.ptf.vo.req.SimuStockOrderVO;
import com.minigod.api.ptf.vo.resp.PtfFlagDetailsVO.SaleInfo;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 创建模拟组合请求值对象
 *
 * @author minigod
 * @date 2015-3-12 上午11:24:35
 * @version v1.0
 */
@TransferBean
public class PtfInfoSimuVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	/** 组合的名字 */
	@Emoji
	private String name;
	
	/** 组合描述 */
	@Emoji
	private String desc;
	
	/** 组合的权限 */
	private Integer perm;
	
	/** 允许他人分享*/
	private String authShare;
	
	/** 部分好友可见时的好友id列表 */
	@TransferID
	private List<Long> uIds;
	
	/** 组合的所有的资产*/
	private List<SimuStockOrderVO> stks;
	public static enum SaleFlag{
		/**
		 * 收费订阅
		 */
		Y,
		/**
		 * 免费订阅
		 */
		N;
	}

	
	private SaleInfo saleInfo;
	
	private boolean createEmptyPtf = false;
	
	public boolean isCreateEmptyPtf() {
		return createEmptyPtf;
	}

	public void setCreateEmptyPtf(boolean createEmptyPtf) {
		this.createEmptyPtf = createEmptyPtf;
	}

	public SaleInfo getSaleInfo() {
		return saleInfo;
	}

	public void setSaleInfo(SaleInfo saleInfo) {
		this.saleInfo = saleInfo;
	}

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

	public Integer getPerm() {
		return perm;
	}

	public void setPerm(Integer perm) {
		this.perm = perm;
	}
	
	public String getAuthShare() {
		return authShare;
	}

	public void setAuthShare(String authShare) {
		this.authShare = authShare;
	}

	public List<Long> getuIds() {
		return uIds;
	}

	public void setuIds(List<Long> uIds) {
		this.uIds = uIds;
	}

	public List<SimuStockOrderVO> getStks() {
		return stks;
	}

	public void setStks(List<SimuStockOrderVO> stks) {
		this.stks = stks;
	}
	
}
