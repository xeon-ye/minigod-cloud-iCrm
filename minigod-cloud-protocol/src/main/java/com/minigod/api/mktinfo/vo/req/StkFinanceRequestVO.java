/**
 * @Title: StkNewRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * @description 个股财务指标
 * 
 * @author 余俊斌
 * @date 2015年10月13日 下午8:17:14
 * @version v1.0
 */
public class StkFinanceRequestVO extends SNVersion {

	private static final long serialVersionUID = -6347178435615361938L;

	private StkFinanceVO params;

	public StkFinanceVO getParams() {
		return params;
	}

	public void setParams(StkFinanceVO params) {
		this.params = params;
	}

	public static class StkFinanceVO extends BaseVO {

		private static final long serialVersionUID = 6633452678564707449L;

		private String assetId;
		private String date;
		private Integer type;

		public String getAssetId() {
			return assetId;
		}

		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

	}

}
