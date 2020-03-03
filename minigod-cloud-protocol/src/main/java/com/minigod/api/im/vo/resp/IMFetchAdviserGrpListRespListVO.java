/**
 * @Title: IMFetchAdviserGrpListRespListzVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.im.vo.resp.IMFetchAdviserGrpListRespVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-4 下午8:44:30
 * @version v1.0
 */
@TransferBean
public class IMFetchAdviserGrpListRespListVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@TransferID
	private List<IMFetchAdviserGrpListRespVO> data;

	public List<IMFetchAdviserGrpListRespVO> getData() {
		return data;
	}

	public void setData(List<IMFetchAdviserGrpListRespVO> data) {
		this.data = data;
	}

}
