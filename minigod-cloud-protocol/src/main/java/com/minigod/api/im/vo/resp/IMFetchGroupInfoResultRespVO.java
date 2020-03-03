/**
 * @Title: IMFetchGroupInfoResultRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author panlz
 * @date 2015-8-27 下午5:11:39
 * @version v1.0
 */
@TransferBean
public class IMFetchGroupInfoResultRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Emoji
	@TransferID
	private IMFetchGroupInfoRespVO data;

	public IMFetchGroupInfoRespVO getData() {
		return data;
	}

	public void setData(IMFetchGroupInfoRespVO data) {
		this.data = data;
	}
}
