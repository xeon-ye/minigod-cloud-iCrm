/**
 * @Title: UpdateNotifyRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 组合更新请求类
 *
 * @author panlz
 * @date 2015-3-26 上午10:19:34
 * @version v1.0
 */
@TransferBean
public class UpdateNotifySummaryRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private UpdateNotifySummaryVO params;

	public UpdateNotifySummaryVO getParams() {
		return params;
	}

	public void setParams(UpdateNotifySummaryVO params) {
		this.params = params;
	}
	
}
