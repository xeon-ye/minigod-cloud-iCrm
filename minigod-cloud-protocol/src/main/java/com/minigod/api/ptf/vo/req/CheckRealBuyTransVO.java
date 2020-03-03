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
 * @description 实盘组合买入预检请求值对象
 *
 * @author minigod
 * @date 2015-3-16 上午9:19:34
 * @version v1.0
 */
@TransferBean
public class CheckRealBuyTransVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private Integer brkId; // 券商ID
	
	private String custId; // 券商端的客户编号
	
	@TransferID
	private Long ptfId; // 组合id

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

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

}
