/**
 * @Title: CheckPtfWithdrawRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */
package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class GetOrderGenerateInfoRequestVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private GetOrderGenerateInfoVO params;

	public GetOrderGenerateInfoVO getParams() {
		return params;
	}

	public void setParams(GetOrderGenerateInfoVO params) {
		this.params = params;
	}
	
	@TransferBean
	public static class GetOrderGenerateInfoVO  extends BaseVO implements Serializable {

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
