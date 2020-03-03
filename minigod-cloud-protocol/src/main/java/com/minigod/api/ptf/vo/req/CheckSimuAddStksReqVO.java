/**
 * @Title: CheckSimuAddStksReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class CheckSimuAddStksReqVO extends BaseVO {

		private static final long serialVersionUID = 1L;

		@TransferID
		private Long ptfId;
		
		private String[] assetIds; // 资产ID集

		
		public Long getPtfId() {
			return ptfId;
		}
		
		public void setPtfId(Long ptfId) {
			this.ptfId = ptfId;
		}
		
		public String[] getAssetIds() {
			return assetIds;
		}
		public void setAssetIds(String[] assetIds) {
			this.assetIds = assetIds;
		}

		
}
