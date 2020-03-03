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
public class CheckSimuAddStksRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private CheckSimuAddStksVO params;

	public CheckSimuAddStksVO getParams() {
		return params;
	}

	public void setParams(CheckSimuAddStksVO params) {
		this.params = params;
	}

	@TransferBean
	public class CheckSimuAddStksVO extends BaseVO {

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

	
	
	
}
