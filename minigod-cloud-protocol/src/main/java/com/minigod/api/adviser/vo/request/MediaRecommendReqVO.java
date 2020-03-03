/**
 * @Title: ViewpointSelectionReqVO.java
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
 * @date 2015-11-5 下午1:58:11
 * @version v1.0
 */
@TransferBean
public class MediaRecommendReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private String requestSrc;
	@TransferID
	private MediaRecommendVO params;

	public MediaRecommendVO getParams() {
		return params;
	}

	public void setParams(MediaRecommendVO params) {
		this.params = params;
	}

	public String getRequestSrc() {
		return requestSrc;
	}

	public void setRequestSrc(String requestSrc) {
		this.requestSrc = requestSrc;
	}
	
}
