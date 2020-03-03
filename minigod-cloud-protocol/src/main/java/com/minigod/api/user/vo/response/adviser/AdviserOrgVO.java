package com.minigod.api.user.vo.response.adviser;

import java.io.Serializable;

/**
 * @Title: AdviserOrgVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-13 下午5:20:39
 * @version v1.0
 */

public class AdviserOrgVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer oId;//投顾机构ID

	private Integer oType;//投顾机构类型，如果是投资咨询机构，不需要填写营业部    1： 表示证券公司    2： 表示证券投资咨询机构

	private String oName;//机构名称

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
	}

	public Integer getoType() {
		return oType;
	}

	public void setoType(Integer oType) {
		this.oType = oType;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}
}
