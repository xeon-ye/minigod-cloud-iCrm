/**
 * @Title: StkFiveBetsVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 获取行业事件
 *
 * @author 余俊斌
 * @date 2015年8月19日 下午5:00:45
 * @version v1.0
 */
public class StkInduNewsParamVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private String induCode;
	private Integer count;
	private Integer newsId;

	public String getInduCode() {
		return induCode;
	}

	public void setInduCode(String induCode) {
		this.induCode = induCode;
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
