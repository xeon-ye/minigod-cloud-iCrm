/**
 * @Title: BrokerLoginInfoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 持仓详情查询请求类
 *
 * @author minigod
 * @date 2015-3-10 上午9:19:34
 * @version v2.0
 */

public class BalanceBrkDetailVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private Integer brkId; // 券商ID
	private String custId; // 券商用户ID
	public Integer getBrkId() {
		return brkId;
	}
	public void setBrkId(Integer brkId) {
		this.brkId = brkId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
}
