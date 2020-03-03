package com.minigod.api.mktserver;

import java.io.Serializable;
import java.util.Date;

/**
 * @description 用于记录删除多余分时数据的删除条件
 *
 * @author 余俊斌
 * @date 2015年7月21日 下午5:26:09
 * @version v1.0
 */
public class ClearTsKey implements Serializable {

	private static final long serialVersionUID = 5539205937104823129L;
	
	private String assetId;
	private Date date;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
