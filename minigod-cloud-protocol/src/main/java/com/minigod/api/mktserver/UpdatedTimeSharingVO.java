/**
 * @Title: UpdatedQuotVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktserver;

import com.minigod.api.quotmonitor.vo.enums.EMarket;
import com.minigod.common.utils.JSONUtil;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-18 下午5:24:30
 * @version v1.0
 */

public class UpdatedTimeSharingVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private EMarket mktCode;

	private Long dbfTs;

	private Object timeSharingVOs;

	public EMarket getMktCode() {
		return mktCode;
	}

	public void setMktCode(EMarket mktCode) {
		this.mktCode = mktCode;
	}

	public Long getDbfTs() {
		return dbfTs;
	}

	public void setDbfTs(Long dbfTs) {
		this.dbfTs = dbfTs;
	}

	public Object getTimeSharingVOs() {
		return timeSharingVOs;
	}

	public void setTimeSharingVOs(Object timeSharingVOs) {
		this.timeSharingVOs = timeSharingVOs;
	}

	public <T> T getConcreteExtraData(Class<T> oCls) {
		return JSONUtil.fromJson(timeSharingVOs.toString(), oCls);
	}
}
