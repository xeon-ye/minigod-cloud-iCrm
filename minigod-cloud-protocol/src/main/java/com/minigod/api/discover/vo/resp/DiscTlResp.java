/**
 *@Title:RespTicker.java
 *@Copyright:©2015 minigod
 *@Company:minigod
 */

package com.minigod.api.discover.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 通联请求返回包装类
 * 
 * @Description
 * @Author 谢尚河
 * @Date 2015-7-16 下午3:13:25
 * @Version v1.0
 */
public class DiscTlResp<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer retCode;
	private String retMsg;
	private List<T> data;

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
