/**
 * @Title: IMFetchAdviserGrpListVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.official.vo.request;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-4 下午7:55:56
 * @version v1.0
 */
@TransferBean
public class OfficialIMFetchAdviserGrpListVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	@TransferID
	private Long adviserUserId; // 投顾的用户ID

	public Long getAdviserUserId() {
		return adviserUserId;
	}

	public void setAdviserUserId(Long adviserUserId) {
		this.adviserUserId = adviserUserId;
	}

}
