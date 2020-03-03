/**
 * @Title: WeiXinSendExpireTimeReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.weixin.vo.req;

import java.io.Serializable;

import com.minigod.api.weixin.vo.req.WeiXinSendTemplateReqVO.WeiXinSendTemplate_key;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-24 下午7:51:50
 * @version v1.0
 */

public class WeiXinSendExpireTimeData  implements Serializable {
	private static final long serialVersionUID = 1L;

	private WeiXinSendTemplate_key first;
	private WeiXinSendTemplate_key keyword1;
	private WeiXinSendTemplate_key keyword2;
	private WeiXinSendTemplate_key keyword3;
	private WeiXinSendTemplate_key remark;
	
	public WeiXinSendTemplate_key getKeyword1() {
		return keyword1;
	}
	public void setKeyword1(WeiXinSendTemplate_key keyword1) {
		this.keyword1 = keyword1;
	}
	public WeiXinSendTemplate_key getKeyword2() {
		return keyword2;
	}
	public void setKeyword2(WeiXinSendTemplate_key keyword2) {
		this.keyword2 = keyword2;
	}
	public WeiXinSendTemplate_key getKeyword3() {
		return keyword3;
	}
	public void setKeyword3(WeiXinSendTemplate_key keyword3) {
		this.keyword3 = keyword3;
	}
	public WeiXinSendTemplate_key getFirst() {
		return first;
	}
	public void setFirst(WeiXinSendTemplate_key first) {
		this.first = first;
	}
	public WeiXinSendTemplate_key getRemark() {
		return remark;
	}
	public void setRemark(WeiXinSendTemplate_key remark) {
		this.remark = remark;
	}
}
