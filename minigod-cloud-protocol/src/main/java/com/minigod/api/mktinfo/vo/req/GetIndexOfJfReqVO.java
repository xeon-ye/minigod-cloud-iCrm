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

public class GetIndexOfJfReqVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	private GetIndexOfJfParamVO params;

	public GetIndexOfJfParamVO getParams() {
		return params;
	}

	public void setParams(GetIndexOfJfParamVO params) {
		this.params = params;
	}
	
	public static class GetIndexOfJfParamVO extends BaseVO {

		private static final long serialVersionUID = 1L;

		private String indexId;//指数标号
		private Integer count;//请求的条数
		private String range; // 查询范围
//		private String mktCode;//市场
		
		public Integer getCount() {
			return count;
		}
		public String getRange() {
			return range;
		}
		public void setRange(String range) {
			this.range = range;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public String getIndexId() {
			return indexId;
		}
		public void setIndexId(String indexId) {
			this.indexId = indexId;
		}
		
	}
}
