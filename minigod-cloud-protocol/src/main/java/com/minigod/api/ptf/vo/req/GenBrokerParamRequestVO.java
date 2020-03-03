/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2016-3-7 下午3:10:41
 * @version v1.0
 */
public class GenBrokerParamRequestVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private GenBrokerParamVO params;

	public GenBrokerParamVO getParams() {
		return params;
	}

	public void setParams(GenBrokerParamVO params) {
		this.params = params;
	}

	public static class GenBrokerParamVO extends BaseVO {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private Integer brkId;
		private String assetId;
		private String ordBS;

		public Integer getBrkId() {
			return brkId;
		}

		public void setBrkId(Integer brkId) {
			this.brkId = brkId;
		}

		public String getAssetId() {
			return assetId;
		}

		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}

		public String getOrdBS() {
			return ordBS;
		}

		public void setOrdBS(String ordBS) {
			this.ordBS = ordBS;
		}

	}
}
