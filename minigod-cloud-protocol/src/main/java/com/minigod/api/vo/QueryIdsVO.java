package com.minigod.api.vo;

import java.io.Serializable;

/**
 * 查询表的汇聚结果集
 */

public class QueryIdsVO implements Serializable {

	private static final long serialVersionUID = 634975947911857674L;
	public static final String ID = "id";

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
