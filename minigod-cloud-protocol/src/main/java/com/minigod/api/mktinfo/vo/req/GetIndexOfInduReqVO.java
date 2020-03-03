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

public class GetIndexOfInduReqVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	private GetIndexOfInduParamVO params;

	public GetIndexOfInduParamVO getParams() {
		return params;
	}

	public void setParams(GetIndexOfInduParamVO params) {
		this.params = params;
	}
	
	public static class GetIndexOfInduParamVO extends BaseVO {

		private static final long serialVersionUID = 1L;

		private String induCode;//行业ID
		private Integer count;//请求的条数
		private String mktCode;//市场
		
		public String getMktCode() {
			return mktCode;
		}
		public void setMktCode(String mktCode) {
			this.mktCode = mktCode;
		}
		public String getInduCode() {
			return induCode;
		}
		public void setInduCode(String labId) {
			this.induCode = labId;
		}
		
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
	}
}
