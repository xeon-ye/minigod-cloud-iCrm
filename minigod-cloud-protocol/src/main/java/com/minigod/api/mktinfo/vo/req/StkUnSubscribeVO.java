/**
 * @Title: StkSubscribeVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import java.util.List;

import com.minigod.api.vo.BaseVO;

/**
 * <code>StkSubscribeVO</code>
 * 
 * @author Jimmy
 * @date 2015-7-1 下午2:14:40
 * @version v1.0
 */
public class StkUnSubscribeVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	/** 通道ID */
	private String chnId;
	/** 功能号 */
	private String funIds;
	/** 取消类型 */
	private String type;
	/** 取消功能对应的内容 */
	private List<String> assetIds;
	
	/** 请求编号 */
	private Long reqNo;
	
	public Long getReqNo() {
		return reqNo;
	}

	public void setReqNo(Long reqNo) {
		this.reqNo = reqNo;
	}

	public List<String> getAssetIds() {
		return assetIds;
	}

	public void setAssetIds(List<String> assetIds) {
		this.assetIds = assetIds;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChnId() {
		return chnId;
	}

	public void setChnId(String chnId) {
		this.chnId = chnId;
	}

	public String getFunIds() {
		return funIds;
	}

	public void setFunIds(String funIds) {
		this.funIds = funIds;
	}
}
