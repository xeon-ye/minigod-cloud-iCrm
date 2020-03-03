/**
 * @Title: SkipFollowVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 放弃跟单参数
 *
 * @author 余俊斌
 * @date 2015年4月15日 下午1:59:02
 * @version v1.0
 */
@TransferBean
public class SkipFollowVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 券商ID
	private Integer brkId;
	// 客户ID
	private String custId;
	// 组合编号
	@TransferID
	private Long ptfId;
	// 组合版本号
	private Integer ptfVer;

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

	public Integer getPtfVer() {
		return ptfVer;
	}

	public void setPtfVer(Integer ptfVer) {
		this.ptfVer = ptfVer;
	}
}
