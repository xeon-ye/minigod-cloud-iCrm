/**
 * @Title: BrokerOpenAccountRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * @description 记录用户券商开户记录
 * @author 谢尚河
 * @date 2015-5-29 下午7:17:29
 * @version v1.0
 */
public class BrokerOpenAccountRequestVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	BrokerOpenAccountVO params;

	public BrokerOpenAccountVO getParams() {
		return params;
	}

	public void setParams(BrokerOpenAccountVO params) {
		this.params = params;
	}

	public static class BrokerOpenAccountVO extends BaseVO implements Serializable {

		private static final long serialVersionUID = 1L;

		private Integer brkId;

		public Integer getBrkId() {
			return brkId;
		}

		public void setBrkId(Integer brkId) {
			this.brkId = brkId;
		}

	}
}
