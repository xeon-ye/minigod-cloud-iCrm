package com.minigod.api.ptf.vo.enums.user_channel;

/**
 * @Description: 客户端操作系统类型
 * @Copyright: © 2015 minigod
 * @Company: minigod
 *
 * @author 余俊斌、许德佑
 * @date 2015-03-10
 * @version v1.0
 */

public enum CurrentStatus {
	N("未绑定"), //
	B("已绑定"), //
	C("已解绑"); //

	private String statusDesc;

	private CurrentStatus(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
	public String getStatusDesc() {
		return this.statusDesc;
	}
}
