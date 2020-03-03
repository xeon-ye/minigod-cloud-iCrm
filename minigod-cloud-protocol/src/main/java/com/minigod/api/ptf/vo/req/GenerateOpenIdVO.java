package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;

/**
 * @Title: GenerateOpenIdVO.java
 * @Description: 请求参数
 * @Copyright: © 2015 minigod
 * @Company: minigod
 *
 * @author 余俊斌、许德佑
 * @date 2015年3月10日 
 * @version v1.0
 */
public class GenerateOpenIdVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer brkId;

	public Integer getBrkId() {
		return brkId;
	}

	public void setBrkId(Integer brkId) {
		this.brkId = brkId;
	}
}
