/**
 * @Title: AdviserViewpointReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-10-30 下午4:21:15
 * @version v1.0
 */
@TransferBean
public class AdviserViewpointReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	@Emoji
	private AdviserViewpointVO params;

	public AdviserViewpointVO getParams() {
		return params;
	}

	public void setParams(AdviserViewpointVO params) {
		this.params = params;
	}
}
