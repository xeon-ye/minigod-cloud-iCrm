/**
 * @Title: SpLabelNewsSimpleVO.java
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
 * @date 2015-7-20 下午8:59:40
 * @version v1.0
 */

public class SpLabelNewsSimpleVO implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer labelNewsId;// 标签新闻ID
	private Date issueTime;// 发布时间
	private String newsSource;// 新闻来源
	private String title;// 标题
	private String dataSource;// 数据来源

	public Integer getLabelNewsId() {
		return labelNewsId;
	}

	public void setLabelNewsId(Integer labelNewsId) {
		this.labelNewsId = labelNewsId;
	}

	public Date getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(Date issueTime) {
		this.issueTime = issueTime;
	}

	public String getNewsSource() {
		return newsSource;
	}

	public void setNewsSource(String newsSource) {
		this.newsSource = newsSource;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

}
