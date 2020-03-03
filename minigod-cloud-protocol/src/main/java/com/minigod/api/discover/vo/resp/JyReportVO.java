/**
 * @Title: JyReportVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.discover.vo.resp;

import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-4 下午5:09:36
 * @version v1.0
 */

public class JyReportVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;// 公告ID
	private Integer innerCode;// 聚源内部ID
	private String infoTitle;// 公告标题
	private String content;// 公告的内容
	private Date infoPublDate;// 公告发布时间
	private Date xgrq;// 外部的时间
	private Date media;// 来源

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getInnerCode() {
		return innerCode;
	}

	public void setInnerCode(Integer innerCode) {
		this.innerCode = innerCode;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getInfoPublDate() {
		return infoPublDate;
	}

	public void setInfoPublDate(Date infoPublDate) {
		this.infoPublDate = infoPublDate;
	}

	public Date getXgrq() {
		return xgrq;
	}

	public void setXgrq(Date xgrq) {
		this.xgrq = xgrq;
	}

	public Date getMedia() {
		return media;
	}

	public void setMedia(Date media) {
		this.media = media;
	}

}
