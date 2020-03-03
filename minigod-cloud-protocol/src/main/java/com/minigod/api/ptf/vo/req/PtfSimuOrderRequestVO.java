/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.util.List;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 组合委托请求值对象
 *
 * @author 许德佑
 * @date 2015-3-16
 * @version v2.0
 */
@TransferBean
public class PtfSimuOrderRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private PtfSimuOrderVO params;

	public PtfSimuOrderVO getParams() {
		return params;
	}

	public void setParams(PtfSimuOrderVO params) {
		this.params = params;
	}
	
	@TransferBean
	public class PtfSimuOrderVO extends BaseVO {

		private static final long serialVersionUID = 1L;
		
		@TransferID
		private Long ptfId; // 组合编号
		
		private List<SimuStockOrderVO> stks;//委托股票列表
		
		public Long getPtfId() {
			return ptfId;
		}

		public void setPtfId(Long ptfId) {
				this.ptfId = ptfId; 
		}

		public List<SimuStockOrderVO> getStks() {
			return stks;
		}

		public void setStks(List<SimuStockOrderVO> stks) {
			this.stks = stks;
		}
	}
}
