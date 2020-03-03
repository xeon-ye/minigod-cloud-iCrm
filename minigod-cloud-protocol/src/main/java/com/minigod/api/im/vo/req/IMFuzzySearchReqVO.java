/**
 * @Title: IMFuzzySearchReqVO.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2016-1-20 上午9:43:04
 * @version v1.0
 */

public class IMFuzzySearchReqVO extends SNVersion {
	private static final long serialVersionUID = -3526719717782625432L;

	private IMFuzzySearchVO params;

	public IMFuzzySearchVO getParams() {
		return params;
	}

	public void setParams(IMFuzzySearchVO params) {
		this.params = params;
	}

	/**
	 * <code>IMFuzzySearchVO</code>
	 */
	public static class IMFuzzySearchVO extends BaseVO {
		private static final long serialVersionUID = 1404661437128125367L;
		private String groupId; // 群ID
		private String searchContent; // 查找的内容
		private Integer pageCount; // 页大小
		private Integer pageNo; // 页码

		public String getSearchContent() {
			return searchContent;
		}

		public void setSearchContent(String searchContent) {
			this.searchContent = searchContent;
		}

		public String getGroupId() {
			return groupId;
		}

		public void setGroupId(String groupId) {
			this.groupId = groupId;
		}

		public Integer getPageCount() {
			return pageCount;
		}

		public void setPageCount(Integer pageCount) {
			this.pageCount = pageCount;
		}

		public Integer getPageNo() {
			return pageNo;
		}

		public void setPageNo(Integer pageNo) {
			this.pageNo = pageNo;
		}

	}
}
