/*
 * FileName: SaveDiaryReqVO.java
 * Copyright: Copyright 2014-12-3 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * 
 * @description 这里描述类的用处
 *
 * @author MiniGod
 * @date 2015-4-17 下午5:06:03
 * @version v1.0
 */

public class WriteTemplateNoteReqVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = 1L;

	private WriteTemplateNoteVO params;

	public WriteTemplateNoteVO getParams() {
		return params;
	}

	public void setParams(WriteTemplateNoteVO params) {
		this.params = params;
	}
	
	
	public static class WriteTemplateNoteVO extends BaseVO{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private Type type;
		private String param;
		
		public Type getType() {
			return type;
		}

		public void setType(Type type) {
			this.type = type;
		}

		public String getParam() {
			return param;
		}



		public void setParam(String param) {
			this.param = param;
		}



		public static enum Type{
			/**
			 * minigod證券國際活期
			 */
			A
		}
		
	}
	
	
}
