/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * @description 委托详情查询请求类
 *
 * @author minigod
 * @date 2015-3-10 上午10:07:49
 * @version v1.0
 */

public class SimuOrderDetailRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	private SimuOrderDetailVO params;

	public SimuOrderDetailVO getParams() {
		return params;
	}

	public void setParams(SimuOrderDetailVO params) {
		this.params = params;
	}
	
	
	public static class SimuOrderDetailVO extends BaseVO {

		private static final long serialVersionUID = 1L;
		
		private Integer ptfTransId; // 组合交易id

		public Integer getPtfTransId() {
			return ptfTransId;
		}

		public void setPtfTransId(Integer ptfTransId) {
			this.ptfTransId = ptfTransId;
		}

	}
	
}
