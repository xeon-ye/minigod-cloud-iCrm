/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.user.vo.response;

import com.minigod.api.user.vo.api.UserSeeStockData;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

import java.io.Serializable;
import java.util.List;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-4-22 下午4:38:21
 * @version v1.0
 */
@TransferBean
public class UserSeeStockListRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	@TransferID
	private List<UserSeeStockData> data;
	
	public List<UserSeeStockData> getData() {
		return data;
	}
	public void setData(List<UserSeeStockData> data) {
		this.data = data;
	}


}
