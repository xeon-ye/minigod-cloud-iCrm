/**
 * @Title: IMGroupMemberSettingRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author minigod
 * @date 2015-9-8 下午8:06:43
 * @version v1.0
 */

public class IMGroupMemberSettingRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer deleteCode = 0; // 删除成员的结果1-失败，0-成功
	private Integer addCode = 0; // 新增成员的结果1-失败，0-成功
	public Integer getDeleteCode() {
		return deleteCode;
	}
	public void setDeleteCode(Integer deleteCode) {
		this.deleteCode = deleteCode;
	}
	public Integer getAddCode() {
		return addCode;
	}
	public void setAddCode(Integer addCode) {
		this.addCode = addCode;
	}
}
