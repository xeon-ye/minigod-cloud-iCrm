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
public class GetPtfOrderListRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	@TransferID
	private GetPtfOrderListVO params;

	public GetPtfOrderListVO getParams() {
		return params;
	}

	public void setParams(GetPtfOrderListVO params) {
		this.params = params;
	}
	
	@TransferBean
	public static class GetPtfOrderListVO extends BaseVO {
		private static final long serialVersionUID = 1L;
	
		@TransferID
		private Long ptfId;
		private OrderStatus status;
		private Integer count;
		
		@TransferID
		private Long locateOrderId;

		public Long getPtfId() {
			return ptfId;
		}

		public void setPtfId(Long ptfId) {
			this.ptfId = ptfId;
		}

		public OrderStatus getStatus() {
			return status;
		}

		public void setStatus(OrderStatus status) {
			this.status = status;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public Long getLocateOrderId() {
			return locateOrderId;
		}

		public void setLocateOrderId(Long locateOrderId) {
			this.locateOrderId = locateOrderId;
		}
	}
	
	public static enum OrderStatus{
		/**
		 * 进行中
		 */
		P,
		/**
		 * 未达成
		 */
		F,
		/**
		 * 已达成
		 */
		S,
		/**
		 * 客户未付款订单	
		 */
		U,
		/**
		 * 所有订单
		 */
		A;
	}
	
	
}
