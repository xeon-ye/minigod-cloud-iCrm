/**
 * @Title: UpdatedQuotVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktserver;

import java.io.Serializable;

import com.minigod.api.quotmonitor.vo.enums.EMarket;
import com.minigod.common.utils.JSONUtil;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-18 下午5:24:30
 * @version v1.0
 */

public class UpdatedQuotVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private EMarket mktCode;

	private Long dbfTs;

	private Object quots;

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

	public Object getQuots() {
		return quots;
	}

	public void setQuots(Object quots) {
		this.quots = quots;
	}

	public <T> T getConcreteExtraData(Class<T> oCls) {
		return JSONUtil.fromJson(quots.toString(), oCls);
	}
}
