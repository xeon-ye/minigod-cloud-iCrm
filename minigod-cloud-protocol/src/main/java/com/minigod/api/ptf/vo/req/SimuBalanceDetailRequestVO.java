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
 * @description 模拟持仓详情查询请求类
 *
 * @author minigod
 * @date 2015-3-10 上午10:07:49
 * @version v1.0
 */
@TransferBean
public class SimuBalanceDetailRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private SimuBalanceDetailVO params;

	public SimuBalanceDetailVO getParams() {
		return params;
	}

	public void setParams(SimuBalanceDetailVO params) {
		this.params = params;
	}
	
	@TransferBean
	public static class SimuBalanceDetailVO extends BaseVO {

		private static final long serialVersionUID = 1L;
		
		@TransferID
		private Long ptfId; // 组合ID

		public Long getPtfId() {
			return ptfId;
		}

		public void setPtfId(Long ptfId) {
			this.ptfId = ptfId;
		}
		
	}

	
	
	
}
