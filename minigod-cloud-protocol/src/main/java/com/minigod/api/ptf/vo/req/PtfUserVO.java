package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;

/**
 * @Title: PtfUserVO.java
 * @Description: 查询某个好友我可见的所有组合请求值对象
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-10-29 下午3:17:34
 * @version v1.0
 */

public class PtfUserVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer tarUid;

	public Integer getTarUid() {
		return tarUid;
	}

	public void setTarUid(Integer tarUid) {
		this.tarUid = tarUid;
	}

}
