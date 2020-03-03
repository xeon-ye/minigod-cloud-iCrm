package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;


/**
 * @Title: GenerateOpenIdRespVO.java
 * @Description 生成OpenId返回VO
 * @Copyright: © 2015 minigod
 * @Company: minigod
 *
 * @author 余俊斌、许德佑
 * @date 2015年3月10日
 * @version v1.0
 */
public class GenerateOpenIdRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String qnOpenId; // minigodopenId
	
	public String getQnOpenId() {
		return qnOpenId;
	}

	public void setQnOpenId(String qnOpenId) {
		this.qnOpenId = qnOpenId;
	}

}
