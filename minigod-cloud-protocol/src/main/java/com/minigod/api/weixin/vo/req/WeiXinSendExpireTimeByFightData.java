/**
 * @Title: WeiXinSendExpireTimeByFightData.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.weixin.vo.req;

import java.io.Serializable;

import com.minigod.api.weixin.vo.req.WeiXinSendTemplateReqVO.WeiXinSendTemplate_key;

/**
 * @description
 * 
 * @author panlz
 * @date 2016-1-27 下午1:51:50
 * @version v1.0
 */

public class WeiXinSendExpireTimeByFightData implements Serializable {
	private static final long serialVersionUID = 1L;

	private WeiXinSendTemplate_key first;
	private WeiXinSendTemplate_key time;
	private WeiXinSendTemplate_key number;
	private WeiXinSendTemplate_key remark;

	public WeiXinSendTemplate_key getFirst() {
		return first;
	}

	public void setFirst(WeiXinSendTemplate_key first) {
		this.first = first;
	}

	public WeiXinSendTemplate_key getTime() {
		return time;
	}

	public void setTime(WeiXinSendTemplate_key time) {
		this.time = time;
	}

	public WeiXinSendTemplate_key getNumber() {
		return number;
	}

	public void setNumber(WeiXinSendTemplate_key number) {
		this.number = number;
	}

	public WeiXinSendTemplate_key getRemark() {
		return remark;
	}

	public void setRemark(WeiXinSendTemplate_key remark) {
		this.remark = remark;
	}

}
