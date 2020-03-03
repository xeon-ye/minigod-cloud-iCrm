package com.minigod.api.discover.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * <code>DiscLabelVersionVO<code>
 *
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-02)
 *
 */
public class DiscLabelVersionVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	private Long ver;// 本地版本号,此参数传递0表示全量拉取概念最新版本
	/**
	 * @return the ver
	 */
	public Long getVer() {
		return ver;
	}
	/**
	 * @param ver the ver to set
	 */
	public void setVer(Long ver) {
		this.ver = ver;
	}
}