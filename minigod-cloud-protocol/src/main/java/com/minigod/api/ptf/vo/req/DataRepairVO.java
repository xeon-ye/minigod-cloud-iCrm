/**
 * @Title: DataRepairVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.util.Map;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-5-19 下午2:51:04
 * @version v1.0
 */

public class DataRepairVO extends BaseVO{
	/**  */
	private static final long serialVersionUID = 1L;
	// 修复数据的类型
	private String type;
	// 修复的内容
	private Map<String, Object> data;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}
