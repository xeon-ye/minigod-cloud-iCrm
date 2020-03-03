/**
 * @Title: StkFiveBetsVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 获取概念事件
 *
 * @author 余俊斌
 * @date 2015年8月19日 下午5:00:45
 * @version v1.0
 */
public class StkLabelNewsParamVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private Integer labId;
	private Integer count;
	private Integer newsId;

	public Integer getLabId() {
		return labId;
	}

	public void setLabId(Integer labId) {
		this.labId = labId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

}
