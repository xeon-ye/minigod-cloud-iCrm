package com.minigod.api.discover.vo.resp;

import java.io.Serializable;


/**
 * <code>DiscLableVersionRespVO<code>
 *
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-02)
 *
 */
public class DiscLabelVersionRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;// 概念分类id

	private String name;// 概念名称

	private String kw;// 概念相关关键子集

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

	/**
	 * @return the kw
	 */
	public String getKw() {
		return kw;
	}

	/**
	 * @param kw
	 *            the kw to set
	 */
	public void setKw(String kw) {
		this.kw = kw;
	}

}
