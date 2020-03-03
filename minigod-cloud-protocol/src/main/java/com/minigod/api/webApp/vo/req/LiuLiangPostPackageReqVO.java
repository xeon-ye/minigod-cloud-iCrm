/**
 * @Title: LiuLiangPostPackageReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import com.minigod.api.webApp.vo.req.AdBaseReqVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-17 下午2:23:24
 * @version v1.0
 */
@TransferBean
public class LiuLiangPostPackageReqVO extends AdBaseReqVO {
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
