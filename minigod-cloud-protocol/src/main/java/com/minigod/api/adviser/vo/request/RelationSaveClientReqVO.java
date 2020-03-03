/**
 * @Title: RelationSaveClientReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-11-18 下午3:16:33
 * @version v1.0
 */
@TransferBean
public class RelationSaveClientReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	private String requestSrc;
	@TransferID
	@Emoji
	private RelationSaveClientVO params;

	public RelationSaveClientVO getParams() {
		return params;
	}

	public void setParams(RelationSaveClientVO params) {
		this.params = params;
	}

	public String getRequestSrc() {
		return requestSrc;
	}

	public void setRequestSrc(String requestSrc) {
		this.requestSrc = requestSrc;
	}

	@TransferBean
	public static class RelationSaveClientVO extends QNAdviserBase {

		private static final long serialVersionUID = 1L;
		@Emoji
		private String message;
		private String reqSrc;
		@TransferID
		private Long rcmdUserId;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getReqSrc() {
			return reqSrc;
		}

		public void setReqSrc(String reqSrc) {
			this.reqSrc = reqSrc;
		}

		public Long getRcmdUserId() {
			return rcmdUserId;
		}

		public void setRcmdUserId(Long rcmdUserId) {
			this.rcmdUserId = rcmdUserId;
		}

	}

}
