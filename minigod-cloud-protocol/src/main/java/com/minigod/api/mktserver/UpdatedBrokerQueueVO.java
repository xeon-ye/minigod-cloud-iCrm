/**
 * @Title: UpdatedQuotVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktserver;

import com.minigod.api.quotmonitor.vo.enums.EMarket;

import java.io.Serializable;
import java.util.Map;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-18 下午5:24:30
 * @version v1.0
 */

public class UpdatedBrokerQueueVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private EMarket mktCode;

	private Long dbfTs;

	private Object bqDatas;

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

	public Object getBqDatas() {
		return bqDatas;
	}

	public void setBqDatas(Object bqDatas) {
		this.bqDatas = bqDatas;
	}
}
