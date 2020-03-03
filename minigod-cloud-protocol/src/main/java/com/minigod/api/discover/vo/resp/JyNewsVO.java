/**
 * @Title: JyNewsVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.discover.vo.resp;

import java.io.Serializable;
import java.util.Date;

/**
 * @description 聚源新闻POJO类
 * 
 * @author 谢尚河
 * @date 2015-8-4 下午2:44:59
 * @version v1.0
 */

public class JyNewsVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;// 新闻ID
	private String infoTitle;// 标题
	private String content;// 内容
	private Date infoPublDate;// 发布时间
	private String media;// 新闻来源
	private Date updateTime;// 更新时间
	private Integer typeCode;// 类型，如1-股票新闻 4-行业新闻
	private Integer code;// 编码,根据类型的不同而有不同的意义

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(Integer typeCode) {
		this.typeCode = typeCode;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
