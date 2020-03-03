package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;


/**
 * @description 组合委托返回值对象
 *
 * @author 许德佑
 * @date 2015-3-16
 * @version v2.0
 */
public class PtfSimuOrderRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ptfTransId; // 组合委托编号
	

	public Integer getPtfTransId() {
		return ptfTransId;
	}

	public void setPtfTransId(Integer ptfTransId) {
		this.ptfTransId = ptfTransId;
	}

}
