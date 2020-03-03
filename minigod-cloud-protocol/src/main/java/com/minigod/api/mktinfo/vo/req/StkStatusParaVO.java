/*
 * FileName: StkStatusVO.java
 * Copyright: Copyright 2014-11-13 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.mktinfo.vo.req;

import java.util.List;

import com.minigod.api.vo.BaseVO;

/**
 * <code>StkStatusVO<code> 股票状态查询 - 请求参数实体类
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-11-13)
 *
 */
public class StkStatusParaVO extends BaseVO{
	/**  */
	private static final long serialVersionUID = 6162966329716046378L;
	
	private List<String> assetIds; // 资产ID集合
	
	public List<String> getAssetIds() {
		return assetIds;
	}
	public void setAssetIds(List<String> assetIds) {
		this.assetIds = assetIds;
	}
}
