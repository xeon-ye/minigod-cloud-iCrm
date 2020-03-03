/**
 * @Title: StkFiveBetsVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 获取概念详情参数对象
 *
 * @author 余俊斌
 * @date 2015年8月19日 下午2:47:56
 * @version v1.0
 */
public class StkLabelDetailParamVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private Integer labId;

	public Integer getLabId() {
		return labId;
	}

	public void setLabId(Integer labId) {
		this.labId = labId;
	}

}
