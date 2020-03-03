/**
 * @Title: EOrderDirection.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums;

/**
 * @description 买卖方向枚举类
 *
 * @author minigod
 * @date 2015-3-12 下午3:11:38
 * @version v1.0
 */

public enum EPtfNoteType {
	R("投顾广场首页最近调仓"),
	M("个人主页观点"),
	G("个人投资圈动态"), 
	S("个股投资圈动态"),
	P("组合的投资笔记");

	private String typeName;

	private EPtfNoteType(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
}
