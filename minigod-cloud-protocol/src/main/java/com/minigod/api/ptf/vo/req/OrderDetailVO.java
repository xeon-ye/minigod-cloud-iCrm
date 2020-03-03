/**
 * @Title: BrokerLoginInfoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 委托详情查询请求类
 *
 * @author minigod
 * @date 2015-3-10 上午9:19:34
 * @version v2.0
 */

public class OrderDetailVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private Integer ptfTransId; // 组合交易id

	public Integer getPtfTransId() {
		return ptfTransId;
	}

	public void setPtfTransId(Integer ptfTransId) {
		this.ptfTransId = ptfTransId;
	}

}
