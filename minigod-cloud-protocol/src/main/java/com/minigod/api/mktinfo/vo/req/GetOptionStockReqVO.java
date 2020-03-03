/**
 * @Title: OptionStockReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * <code>StkQuotReqVO</code>
 * 
 * @author xiongpan
 * @date 2015-7-1 下午1:45:42
 * @version v1.0
 */
@TransferBean
public class GetOptionStockReqVO extends SNVersion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private GetOptionStockVo params;
	
	public GetOptionStockVo getParams() {
		return params;
	}
	public void setParams(GetOptionStockVo params) {
		this.params = params;
	}
	
	@TransferBean
	public static class GetOptionStockVo extends BaseVO {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		@TransferID
		private Long tarUserId;

		public Long getTarUserId() {
			return tarUserId;
		}

		public void setTarUserId(Long tarUserId) {
			this.tarUserId = tarUserId;
		}
	}
	
	
	
}
