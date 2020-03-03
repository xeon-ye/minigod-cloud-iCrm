package com.minigod.api.discover.vo.resp;

import com.minigod.api.vo.BaseVO;

/**
 * <code>DiscLabelVO<code>
 *
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-05)
 *
 */
public class DiscLabelVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private String id;// 概念的ID

	private String name;// 概念的名

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
