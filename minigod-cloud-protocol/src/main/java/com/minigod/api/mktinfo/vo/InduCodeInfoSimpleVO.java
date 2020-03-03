/**
 * @Title: InduCodeInfoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-17 下午10:48:18
 * @version v1.0
 */

public class InduCodeInfoSimpleVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String induCodeB;// 行业二级代码
	private String induNameB;// 行业二级名称

	public String getInduCodeB() {
		return induCodeB;
	}

	public void setInduCodeB(String induCodeB) {
		this.induCodeB = induCodeB;
	}

	public String getInduNameB() {
		return induNameB;
	}

	public void setInduNameB(String induNameB) {
		this.induNameB = induNameB;
	}

}
