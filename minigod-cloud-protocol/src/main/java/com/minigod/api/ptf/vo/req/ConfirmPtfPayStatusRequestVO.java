/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class ConfirmPtfPayStatusRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	@TransferID
	private ConfirmPtfPayStatusVO params;

	public ConfirmPtfPayStatusVO getParams() {
		return params;
	}

	public void setParams(ConfirmPtfPayStatusVO params) {
		this.params = params;
	}
	
	@TransferBean
	public static class ConfirmPtfPayStatusVO extends BaseVO {
		private static final long serialVersionUID = 1L;
		
		private String payChannel;//W微信
		
		@TransferID
		private Long orderId;

		public String getPayChannel() {
			return payChannel;
		}

		public void setPayChannel(String payChannel) {
			this.payChannel = payChannel;
		}

		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}
	}
	
}
