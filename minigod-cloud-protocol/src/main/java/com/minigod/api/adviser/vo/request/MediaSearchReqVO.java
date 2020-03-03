/**
 * @Title: RelationDelClientReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-11-16 上午10:27:37
 * @version v1.0
 */
@TransferBean
public class MediaSearchReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	private String requestSrc;
	@TransferID
	private MediaSearchVO params;

	public MediaSearchVO getParams() {
		return params;
	}

	public void setParams(MediaSearchVO params) {
		this.params = params;
	}
	public String getRequestSrc() {
		return requestSrc;
	}
	public void setRequestSrc(String requestSrc) {
		this.requestSrc = requestSrc;
	}

	@TransferBean
	public static class MediaSearchVO extends QNAdviserBase {

		private static final long serialVersionUID = 1L;
		
		private Integer count;
		private Integer moreId;
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public Integer getMoreId() {
			return moreId;
		}

		public void setMoreId(Integer moreId) {
			this.moreId = moreId;
		}
		
		

	}
}
