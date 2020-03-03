/**
 * @Title: StkFiveBetsVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 获取行业详情参数对象
 *
 * @author 余俊斌
 * @date 2015年8月19日 下午2:47:56
 * @version v1.0
 */
public class StkInduDetailParamVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private String induCode;
	private String mktCode;//市场

	public String getMktCode() {
		return mktCode;
	}

	public void setMktCode(String mktCode) {
		this.mktCode = mktCode;
	}

	public String getInduCode() {
		return induCode;
	}

	public void setInduCode(String induCode) {
		this.induCode = induCode;
	}

}
