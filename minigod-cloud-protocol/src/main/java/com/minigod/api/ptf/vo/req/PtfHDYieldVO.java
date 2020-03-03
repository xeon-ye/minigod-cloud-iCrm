package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * <code>PtfHDYieldVO<code> 创建后的指数的历史收益率 请求实体类。
 * 
 * @author Jimmy
 * @since MiniGod v0.0.1 (2014-11-10)
 * 
 */
@TransferBean
public class PtfHDYieldVO extends BaseVO {
	private static final long serialVersionUID = -2226379658426801433L;
	private Integer period;
	
	@TransferID
	private Long ptfId;
	private Integer action;

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

}