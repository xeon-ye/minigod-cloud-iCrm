/**
 * @Title: ITNDepositVchRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.itn;

import com.minigod.api.gateway.vo.req.itn.ITNRequest;

/**
 * @description iTN资金流水查询请求
 *
 * @author 余俊斌
 * @date 2015年7月3日 下午4:03:19
 * @version v1.0
 */

public class ITNDepositVchRequest extends ITNRequest {

	private static final long serialVersionUID = 1L;
	// 开始日期
	private String start_date;
	// 到期日期
	private String end_date;

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
}
