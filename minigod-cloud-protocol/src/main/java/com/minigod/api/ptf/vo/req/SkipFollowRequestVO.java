/**
 * @Title: SkipFollowRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 放弃跟单请求
 *
 * @author 余俊斌
 * @date 2015年4月15日 下午1:58:31
 * @version v1.0
 */
@TransferBean
public class SkipFollowRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	@TransferID
	SkipFollowVO params;

	public SkipFollowVO getParams() {
		return params;
	}

	public void setParams(SkipFollowVO params) {
		this.params = params;
	}
}
