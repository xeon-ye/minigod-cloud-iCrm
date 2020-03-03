/**
 * @Title: IMFetchChatHistoryRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;
import java.util.Map;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-10-21 上午11:17:40
 * @version v1.0
 */

public class IMFetchChatHistoryRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 公共的属性
	private String id; // 消息的ID
	private String type;
	private Integer msgType;
	private String from;
	private String to;
	private Map<String, Object> ext;
	// 文本
	private String data;
	// 图片
	private String filename;
	private String thumb;
	private String url;
	private String ownerImId;
	
	public String getOwnerImId() {
		return ownerImId;
	}

	public void setOwnerImId(String ownerImId) {
		this.ownerImId = ownerImId;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Map<String, Object> getExt() {
		return ext;
	}

	public void setExt(Map<String, Object> ext) {
		this.ext = ext;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
