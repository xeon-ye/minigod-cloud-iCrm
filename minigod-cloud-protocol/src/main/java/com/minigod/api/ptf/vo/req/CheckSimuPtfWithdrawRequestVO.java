/**
 * @Title: CheckPtfWithdrawRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */
package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * @description 组合撤单预检请求值对象
 *
 * @author minigod
 * @date 2015-3-31 下午4:19:05
 * @version v1.0
 */

public class CheckSimuPtfWithdrawRequestVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	private CheckSimuPtfWithdrawVO params;

	public CheckSimuPtfWithdrawVO getParams() {
		return params;
	}

	public void setParams(CheckSimuPtfWithdrawVO params) {
		this.params = params;
	}
	
	public static class CheckSimuPtfWithdrawVO  extends BaseVO implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private Integer ptfTransId; // 交易id

		public Integer getPtfTransId() {
			return ptfTransId;
		}

		public void setPtfTransId(Integer ptfTransId) {
			this.ptfTransId = ptfTransId;
		}
		
	}	
}
