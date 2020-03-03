/**
 * @Title: LiuLiangRegValidRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-16 下午4:41:13
 * @version v1.0
 */
@TransferBean
public class LiuLiangRegValidRespVO implements Serializable{
	private static final long serialVersionUID = 1L;

	@TransferID
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
