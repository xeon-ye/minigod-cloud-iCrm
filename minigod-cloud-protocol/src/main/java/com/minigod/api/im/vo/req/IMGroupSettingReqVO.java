/**
 * @Title: IMGroupSettingReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-11-12 下午4:07:30
 * @version v1.0
 */
@TransferBean
public class IMGroupSettingReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	@Emoji
	private IMGroupSettingVO params;

	public IMGroupSettingVO getParams() {
		return params;
	}

	public void setParams(IMGroupSettingVO params) {
		this.params = params;
	}
}
