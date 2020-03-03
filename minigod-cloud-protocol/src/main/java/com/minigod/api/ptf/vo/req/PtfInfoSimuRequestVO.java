/**
 * @Title: PtfInfoSimuRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 创建模拟组合请求
 *
 * @author minigod
 * @date 2015-3-12 上午11:23:01
 * @version v1.0
 */
@TransferBean
public class PtfInfoSimuRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	@Emoji
	private PtfInfoSimuVO params;

	public PtfInfoSimuVO getParams() {
		return params;
	}

	public void setParams(PtfInfoSimuVO params) {
		this.params = params;
	}
}
