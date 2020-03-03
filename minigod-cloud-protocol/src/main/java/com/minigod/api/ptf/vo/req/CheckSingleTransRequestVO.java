/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2016-2-26 下午1:13:14
 * @version v1.0
 */
@TransferBean
public class CheckSingleTransRequestVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	@TransferID
	private CheckSingleTransVO params;

	public CheckSingleTransVO getParams() {
		return params;
	}

	public void setParams(CheckSingleTransVO params) {
		this.params = params;
	}

	@TransferBean
	public static class CheckSingleTransVO extends BaseVO {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@TransferID
		private Long ptfId;// 组合ID
		private BrokerAcc brokerAcc;
		private String assetId; // 证券id

		public Long getPtfId() {
			return ptfId;
		}

		public void setPtfId(Long ptfId) {
			this.ptfId = ptfId;
		}

		public BrokerAcc getBrokerAcc() {
			return brokerAcc;
		}

		public void setBrokerAcc(BrokerAcc brokerAcc) {
			this.brokerAcc = brokerAcc;
		}

		public String getAssetId() {
			return assetId;
		}

		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}

	}

}
