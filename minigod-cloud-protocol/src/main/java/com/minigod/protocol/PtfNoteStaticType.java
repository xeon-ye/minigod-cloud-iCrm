/**
 * @Title: PtfNoteStaticType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-5-3 下午2:43:58
 * @version v1.0
 */

public class PtfNoteStaticType {
	private static final Map<Integer, CodeType> map = new HashMap<Integer, PtfNoteStaticType.CodeType>();
	
	public enum CodeType{
		NOTE_NOT_EXIT(888, "该帖不存在或已被删除"),
		INTER_NOT_EXIT(888, "该评论不存在或已被删除"),
		NOT_FRIEND(888,"操作失败，你们还不是好友关系"),
		NOT_YOUR_PTF(888,"没有操作权限"),
		NOT_QUTH_VIEW(888,"没有查看该组合的权限 或者 该组合已被删除"),
		NOT_QUTH_HANDLE(888,"没有操作权限"),
		CONTENT_IS_NULL(888,"内容不能为空"),
		CONTENT_OUT_LIMIT(888,"你输入的内容过长"),
		NOTE_CONTENT_OUT_LIMIT(888,"你输入的内容过长"),
		TRANS_NOT_EXIT(888,"保存失败,请联系客服"),
		NOTE_IS_NOT_EXIT(1001,"抱歉！该贴子不存在或已被删除"),
		PTF_NOTE_NOT_PRIVILEGE(888,"组合已被删除 或者 没有权限浏览该组合信息"),
		ERROR_UNKNOWN(100, "未知错误");
		
		private int code;
		private String message;

		private CodeType(int code, String message) {
			this.code = code;
			this.message = message;
			map.put(code, this);
		}

		public int getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		public static final String getMessage(int code) {
			CodeType _code = map.get(code);
			if (_code == null) {
				return ERROR_UNKNOWN.getMessage();
			}
			return _code.getMessage();
		}
	}
}
