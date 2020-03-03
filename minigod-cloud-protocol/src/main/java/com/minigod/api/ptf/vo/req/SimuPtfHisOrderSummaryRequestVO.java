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
 * @date 2016-3-14 下午1:52:04
 * @version v1.0
 */
@TransferBean
public class SimuPtfHisOrderSummaryRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	@TransferID
	private HisSimuOrderSummaryVO params;

	public HisSimuOrderSummaryVO getParams() {
		return params;
	}
	public void setParams(HisSimuOrderSummaryVO params) {
		this.params = params;
	}

	@TransferBean
	public static class HisSimuOrderSummaryVO extends BaseVO {

		private static final long serialVersionUID = 1L;

		@TransferID
		private Long ptfId;

		private Integer reqNum; // 请求的记录数

		private Integer pos; // 当前记录读到哪里

		private Integer pullMode; // 拉取方式

		public Integer getReqNum() {
			return reqNum;
		}

		public void setReqNum(Integer reqNum) {
			this.reqNum = reqNum;
		}

		public Integer getPos() {
			return pos;
		}

		public void setPos(Integer pos) {
			this.pos = pos;
		}

		public Integer getPullMode() {
			return pullMode;
		}

		public void setPullMode(Integer pullMode) {
			this.pullMode = pullMode;
		}

		public Long getPtfId() {
			return ptfId;
		}

		public void setPtfId(Long ptfId) {
			this.ptfId = ptfId;
		}

	}

}
