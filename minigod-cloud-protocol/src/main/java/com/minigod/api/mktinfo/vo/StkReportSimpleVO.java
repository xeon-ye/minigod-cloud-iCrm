/**
 * @Title: StkReportSimpleVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-7-20 下午9:09:20
 * @version v1.0
 */

public class StkReportSimpleVO implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer reportId;// 公告ID
	private String title;// 公告标题
	private Date publishDate;// 公告发布时间

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}
