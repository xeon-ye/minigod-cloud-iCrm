/**
 * @Title: CheckRealSellTransVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author panlz
 * @date 2015-3-30 下午3:50:14
 * @version v1.0
 */
@TransferBean
public class CheckRealSellTransVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private Long ptfId; // 组合编号
	
	private Integer brkId; // 券商ID
	private String custId; // 券商用户ID
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
