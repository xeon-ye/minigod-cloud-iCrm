/**
 * @Title: FollowCheckRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 跟单预检查请求
 *
 * @author 余俊斌
 * @date 2015年3月25日 下午7:54:02
 * @version v1.0
 */
@TransferBean
public class FollowCheckRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private FollowCheckVO params;

	public FollowCheckVO getParams() {
		return params;
	}

	public void setParams(FollowCheckVO params) {
		this.params = params;
	}

}
