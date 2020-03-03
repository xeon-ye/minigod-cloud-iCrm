package com.minigod.api.discover.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * <code>DiscLableEventVO<code>
 *
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-02)
 *
 */
public class DiscLabelNewsVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private Integer pullMode;// 拉取数据的方式，0表示拉取更新，1表示拉取更多历史数据（下一页）

	private Integer count;// 拉取概念事件的数量

	private Integer eId;// 服务器数据默认以事件的时间排序，并根据拉取方式返回以此事件ID为起点count条数据给客户端。不传此参数表示拉取服务器当前最新的count条数据。

	/**
	 * @return the pullMode
	 */
	public Integer getPullMode() {
		return pullMode;
	}

	/**
	 * @param pullMode
	 *            the pullMode to set
	 */
	public void setPullMode(Integer pullMode) {
		this.pullMode = pullMode;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the eId
	 */
	public Integer geteId() {
		return eId;
	}

	/**
	 * @param eId
	 *            the eId to set
	 */
	public void seteId(Integer eId) {
		this.eId = eId;
	}

}
