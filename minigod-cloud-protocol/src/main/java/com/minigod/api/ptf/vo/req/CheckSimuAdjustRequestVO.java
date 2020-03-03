package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 
 * @description 组合调仓预检请求类
 *
 * @author 许德佑
 * @date 2015-4-24
 * @version v1.0
 */
@TransferBean
public class CheckSimuAdjustRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private CheckSimuAdjustVO params;

	public CheckSimuAdjustVO getParams() {
		return params;
	}

	public void setParams(CheckSimuAdjustVO params) {
		this.params = params;
	}
	
	@TransferBean
	public static class CheckSimuAdjustVO extends BaseVO {

		private static final long serialVersionUID = 1L;
		
		@TransferID
		private Long ptfId; // 组合编号
		
		public Long getPtfId() {
			return ptfId;
		}
		public void setPtfId(Long ptfId) {
			this.ptfId = ptfId;
		}
	}
}
