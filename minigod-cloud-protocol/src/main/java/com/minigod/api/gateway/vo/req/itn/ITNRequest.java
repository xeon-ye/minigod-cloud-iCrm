/**
 * @Title: ITNRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.itn;

import java.io.Serializable;

/**
 * @description iTN请求公用类
 *
 * @author 余俊斌
 * @date 2015年7月2日 上午10:18:49
 * @version v1.0
 */

public class ITNRequest implements Serializable {

	private static final long serialVersionUID = 7910257845585867276L;
	
	// 定位串，空格表示取第一页
	private String position_str;
	// 请求行数
	private Integer request_num;

	public String getPosition_str() {
		return position_str;
	}

	public void setPosition_str(String position_str) {
		this.position_str = position_str;
	}

	public Integer getRequest_num() {
		return request_num;
	}

	public void setRequest_num(Integer request_num) {
		this.request_num = request_num;
	}

}
