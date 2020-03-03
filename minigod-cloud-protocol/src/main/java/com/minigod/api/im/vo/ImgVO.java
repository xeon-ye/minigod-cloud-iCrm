/**
 * @Title: ImgVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo;

import com.minigod.api.im.vo.MsgBaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-9-25 下午3:29:08
 * @version v1.0
 */

public class ImgVO extends MsgBaseVO {
	/** */
	private static final long serialVersionUID = 1L;

	private String filename;

	private String url; // 原图

	private String thumbUrl; // 缩略图

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
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
}
