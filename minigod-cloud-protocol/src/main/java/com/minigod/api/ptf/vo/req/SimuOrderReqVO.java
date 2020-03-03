/**
 * @Title: SimuOrderReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 模拟组合查询请求类
 *
 * @author panlz
 * @date 2015-7-21 下午7:07:49
 * @version v1.0
 */
@TransferBean
public class SimuOrderReqVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
    private Long ptfId;
	
	private Integer ptfTransId; // 组合交易id
	
	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	} 
	
	public Integer getPtfTransId() {
		return ptfTransId;
	}

	public void setPtfTransId(Integer ptfTransId) {
		this.ptfTransId = ptfTransId;
	}
	
}
