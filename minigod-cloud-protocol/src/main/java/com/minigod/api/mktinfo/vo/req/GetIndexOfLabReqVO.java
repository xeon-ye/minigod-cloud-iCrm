/**
 * @Title: StkBaseInfoReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author 许德佑
 */

public class GetIndexOfLabReqVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	private GetIndexOfLabParamVO params;

	public GetIndexOfLabParamVO getParams() {
		return params;
	}

	public void setParams(GetIndexOfLabParamVO params) {
		this.params = params;
	}
	
	public static class GetIndexOfLabParamVO extends BaseVO {

		private static final long serialVersionUID = 1L;

		private Integer labId;//概念ID
		private Integer count;//请求的条数
		
		public Integer getLabId() {
			return labId;
		}
		public void setLabId(Integer labId) {
			this.labId = labId;
		}
		
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
	}
}
