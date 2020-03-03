/**
 * @Title: BrokerLoginInfoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 交易历史详情查询请求类
 *
 * @author minigod
 * @date 2015-3-10 上午9:19:34
 * @version v2.0
 */

public class HisOrderDetailVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private Integer ptfTransId; // 券商ID

	public Integer getPtfTransId() {
		return ptfTransId;
	}

	public void setPtfTransId(Integer ptfTransId) {
		this.ptfTransId = ptfTransId;
	}
	
}
