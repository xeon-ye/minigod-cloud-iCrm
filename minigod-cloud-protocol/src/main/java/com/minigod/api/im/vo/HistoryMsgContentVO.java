/**
 * @Title: HistoryMsgVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-10-22 上午10:47:49
 * @version v1.0
 */

public class HistoryMsgContentVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> ext;

	private String msg;

	private String filename;

	private String url; // 原图

	private String thumbUrl; // 缩略图
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<String, Object> getExt() {
		return ext;
	}

	public void setExt(Map<String, Object> ext) {
		this.ext = ext;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
}
