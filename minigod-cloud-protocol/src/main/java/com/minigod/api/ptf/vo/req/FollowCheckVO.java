/**
 * @Title: FollowCheck.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 跟单预检查
 *
 * @author 余俊斌
 * @date 2015年3月25日 下午7:53:14
 * @version v1.0
 */
@TransferBean
public class FollowCheckVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	// 券商ID
	private Integer brkId;
	// 客户ID
	private String custId;
	
	// 组合编号
	@TransferID
	private Long ptfId;

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
