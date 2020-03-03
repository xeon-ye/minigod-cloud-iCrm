/**
 * @Title: GameFightbaseReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 一战到底 请求基类
 * 
 * @author panlz
 * @date 2015-12-7 下午1:34:55
 * @version v1.0
 */
@TransferBean
public class GameFightbaseReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer sessionUserId;
	@TransferID
	private String tarUserId; // 对端用户id
	@TransferID
	private String readId; // 传最后一条的赛事id
	private Integer count; // 每次拉取的条数

	public Integer getSessionUserId() {
		return sessionUserId;
	}

	public void setSessionUserId(Integer sessionUserId) {
		this.sessionUserId = sessionUserId;
	}

	public String getTarUserId() {
		return tarUserId;
	}

	public void setTarUserId(String tarUserId) {
		this.tarUserId = tarUserId;
	}

	public String getReadId() {
		return readId;
	}

	public void setReadId(String readId) {
		this.readId = readId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
