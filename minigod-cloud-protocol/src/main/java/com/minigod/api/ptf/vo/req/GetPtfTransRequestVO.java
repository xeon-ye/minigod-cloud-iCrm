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
 * @date 2016-2-25 下午1:29:41
 * @version v1.0
 */
@TransferBean
public class GetPtfTransRequestVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	@TransferID
	private GetPtfTransVO params;

	public GetPtfTransVO getParams() {
		return params;
	}

	public void setParams(GetPtfTransVO params) {
		this.params = params;
	}

	@TransferBean
	public static class GetPtfTransVO extends BaseVO {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@TransferID
		private Long ptfId;// 组合ID
		private BrokerAcc brokerAcc;
		private ETransType type;// 拉取类型
		private Long ptfTransId;
		private Integer count; // 拉取条数

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

		public ETransType getType() {
			return type;
		}

		public void setType(ETransType type) {
			this.type = type;
		}

		public Long getPtfTransId() {
			return ptfTransId;
		}

		public void setPtfTransId(Long ptfTransId) {
			this.ptfTransId = ptfTransId;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

	}

	public enum ETransType {
		T, // 当天
		H;// 历史
	}

}
