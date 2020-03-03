/**
 * @Title: IMFetchGroupReqRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-11-20 上午11:21:11
 * @version v1.0
 */
@TransferBean
public class IMFetchGroupReqRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@TransferID
	@Emoji
	private List<IMFetchGroupReqVO> data;
	
	private Integer unreadCount;
	
	public Integer getUnreadCount() {
		return unreadCount;
	}

	public void setUnreadCount(Integer unreadCount) {
		this.unreadCount = unreadCount;
	}

	public List<IMFetchGroupReqVO> getData() {
		return data;
	}

	public void setData(List<IMFetchGroupReqVO> data) {
		this.data = data;
	}
}
