package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

import com.minigod.api.webApp.vo.req.GameFightbaseReqVO;
import com.minigod.common.anno.TransferBean;

/**
 * <code>GameFightEventListReqVO<code>
 * 
 * @author panlz 一战到底 获取赛程列表
 * 
 */
@TransferBean
public class GameFightEventListReqVO extends GameFightbaseReqVO implements Serializable {
	/**  */
	private static final long serialVersionUID = -5232267923290668354L;

	private String isMy; // 是否只显示我的 Y是

	public String getIsMy() {
		return isMy;
	}

	public void setIsMy(String isMy) {
		this.isMy = isMy;
	}

}
