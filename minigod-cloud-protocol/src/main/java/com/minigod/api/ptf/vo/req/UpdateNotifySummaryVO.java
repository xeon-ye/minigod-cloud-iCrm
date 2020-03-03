/**
 * @Title: UpdateNotifyVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
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
public class UpdateNotifySummaryVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private Long ptfId; // 组合编号
	
	public Long getPtfId() {
		return ptfId;
	}
	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}
	
	

	
	
	
}
