/**
 * @Title: GuestRegisterVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.GuestRegInfo;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * @description 游客注册类
 *
 * @author minigod
 * @date 2015-10-14 下午3:29:06
 * @version v1.0
 */

@TransferBean
public class GuestRegisterVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;

	@Emoji
	private GuestRegInfo params;

	public GuestRegInfo getParams() {
		return params;
	}

	public void setParams(GuestRegInfo params) {
		this.params = params;
	}
	
}
