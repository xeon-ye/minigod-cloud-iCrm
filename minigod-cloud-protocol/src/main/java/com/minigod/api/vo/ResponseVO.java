/**
 * @Title: PortfolioDao.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */
package com.minigod.api.vo;

import java.io.Serializable;

import com.minigod.api.user.vo.QNUpdateVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
import com.minigod.protocol.StaticType;

/**
 * @description 返回公共值对象
 * 
 * @author ken
 * @date 2015-3-13 下午10:26:00
 * @version v1.0
 */

@TransferBean
public class ResponseVO implements Serializable {

	private static final long serialVersionUID = 4675414552962434446L;

	private Integer code = StaticType.CodeType.OK.getCode(); //返回的状态
	private String message; //返回的消息
	private QNUpdateVersion updateMsg;//接口中APP更新的信息
	private Integer id; // 返回前端生成的id,实盘版本添加

	@TransferID
	@Emoji
	private Object result; //返回的结果

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public QNUpdateVersion getUpdateMsg() {
		return updateMsg;
	}

	public void setUpdateMsg(QNUpdateVersion updateMsg) {
		this.updateMsg = updateMsg;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public ResponseVO() {
		super();
	}

	public ResponseVO(Object result) {
		super();
		this.result = result;
	}

	public ResponseVO(Integer code, String message, Integer id, Object result) {
		super();
		this.code = code;
		this.message = message;
		this.id = id;
		this.result = result;
	}
}
