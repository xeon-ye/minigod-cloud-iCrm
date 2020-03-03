/**
 * @Title: ViewpointInteractionReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-3 下午5:10:13
 * @version v1.0
 */
@TransferBean
public class ViewpointInteractionReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	@TransferID
	@Emoji
	private ViewpointInteractionVO params;

	public ViewpointInteractionVO getParams() {
		return params;
	}

	public void setParams(ViewpointInteractionVO params) {
		this.params = params;
	}
}
