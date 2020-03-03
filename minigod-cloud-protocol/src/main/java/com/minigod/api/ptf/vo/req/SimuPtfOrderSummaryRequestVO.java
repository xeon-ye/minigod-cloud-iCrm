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

/**
 * @description 委托概要查询请求类
 *
 * @author minigod
 * @date 2015-3-10 上午10:07:49
 * @version v1.0
 */
@TransferBean
public class SimuPtfOrderSummaryRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private SimuOrderSummaryVO params;

	public SimuOrderSummaryVO getParams() {
		return params;
	}

	public void setParams(SimuOrderSummaryVO params) {
		this.params = params;
	}
	
	@TransferBean
	public class SimuOrderSummaryVO extends BaseVO {

		private static final long serialVersionUID = 1L;
		
		@TransferID
	    private Long ptfId;

		public Long getPtfId() {
			return ptfId;
		}

		public void setPtfId(Long ptfId) {
			this.ptfId = ptfId;
		} 
		
	}
	
}
