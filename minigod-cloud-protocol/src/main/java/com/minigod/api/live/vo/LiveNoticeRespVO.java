/**
 * @Title: IMFetchGroupListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.live.vo;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

import java.io.Serializable;
import java.util.List;

/**
 * @description
 * 
 * @author huhu
 * @date 2015-8-21 下午3:53:10
 * @version v1.0
 */
@TransferBean
public class LiveNoticeRespVO implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;
	@TransferID
	private List<LiveNoticeVO> liveNoticeVOList;

	public List<LiveNoticeVO> getLiveNoticeVOList() {
		return liveNoticeVOList;
	}

	public void setLiveNoticeVOList(List<LiveNoticeVO> liveNoticeVOList) {
		this.liveNoticeVOList = liveNoticeVOList;
	}
}
