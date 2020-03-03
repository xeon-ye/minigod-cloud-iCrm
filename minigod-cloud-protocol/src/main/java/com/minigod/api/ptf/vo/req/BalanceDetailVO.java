/**
 * @Title: BrokerLoginInfoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 持仓详情查询请求类
 *
 * @author minigod
 * @date 2015-3-10 上午9:19:34
 * @version v2.0
 */

@TransferBean
public class BalanceDetailVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private Integer ptfBalId; // 券商ID
	
	@TransferID
	private Long ptfId; // 组合ID
	
    private Integer brkId; // 券商ID
	
	private String custId; // 券商端的客户编号

	public Integer getPtfBalId() {
		return ptfBalId;
	}

	public void setPtfBalId(Integer ptfBalId) {
		this.ptfBalId = ptfBalId;
	}

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

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
