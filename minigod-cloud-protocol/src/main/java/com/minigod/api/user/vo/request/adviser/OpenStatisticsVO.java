package com.minigod.api.user.vo.request.adviser;

import java.io.Serializable;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: OpenStatisticsVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author panlz
 * @date 2015-9-28 下午5:15:47
 * @version v1.0
 */
@TransferBean
public class OpenStatisticsVO extends SNUserBase implements Serializable {

	private static final long serialVersionUID = 2406842815060417640L;
	@TransferID
	private Long adviserUserId ; //投顾用户id
	
	private String openUrl ; //开户url

	public Long getAdviserUserId() {
		return adviserUserId;
	}

	public void setAdviserUserId(Long adviserUserId) {
		this.adviserUserId = adviserUserId;
	}

	public String getOpenUrl() {
		return openUrl;
	}

	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}
	
}
