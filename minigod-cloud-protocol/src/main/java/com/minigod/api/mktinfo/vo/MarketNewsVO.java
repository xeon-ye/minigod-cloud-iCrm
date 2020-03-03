/**
 * @Title: MarketNewVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import com.minigod.api.mktinfo.vo.resp.MarketNewRespVO;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-9-21 下午9:23:52
 * @version v1.0
 */

public class MarketNewsVO extends MarketNewRespVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean isImportant;// 是否是要闻
	private Boolean isLive;// 是否是直播
	private Integer treeid;
	
	public Integer getTreeid() {
		return treeid;
	}

	public void setTreeid(Integer treeid) {
		this.treeid = treeid;
	}

	public Boolean getIsImportant() {
		return isImportant;
	}

	public void setIsImportant(Boolean isImportant) {
		this.isImportant = isImportant;
	}

	public Boolean getIsLive() {
		return isLive;
	}

	public void setIsLive(Boolean isLive) {
		this.isLive = isLive;
	}

}
