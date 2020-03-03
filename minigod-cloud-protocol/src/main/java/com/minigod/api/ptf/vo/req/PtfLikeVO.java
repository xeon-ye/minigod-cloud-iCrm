/**
 * @Title: PtfLikeVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 组合点赞值对象
 *
 * @author minigod
 * @date 2015-4-11 上午10:29:35
 * @version v1.0
 */
@TransferBean
public class PtfLikeVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@TransferID
	private Long ptfId; // 组合id
	
	private String isLike; // 是否点赞

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

	public String getIsLike() {
		return isLike;
	}

	public void setIsLike(String isLike) {
		this.isLike = isLike;
	}
	
}
