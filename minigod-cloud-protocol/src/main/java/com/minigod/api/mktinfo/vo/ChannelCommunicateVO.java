/**
 * @Title: ChannelCommunicateVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import com.minigod.api.mktinfo.vo.enums.EAction;
import com.minigod.common.utils.JSONUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @description 内部Redis同一个通道交换数据对象
 * 
 * @author Jimmy
 * @date 2015-12-7 下午3:22:08
 * @version v1.0
 */

public class ChannelCommunicateVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private EAction action;

	private Object extraData;

	private Date time;

	public EAction getAction() {
		return action;
	}

	public void setAction(EAction action) {
		this.action = action;
	}

	public <T> T getConcreteExtraData(Class<T> oCls) {
		return JSONUtil.fromJson(extraData.toString(), oCls);
	}

	public Object getExtraData() {
		return extraData;
	}

	public void setExtraData(Object extraData) {
		this.extraData = extraData;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
