package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;

/**
 * @Title: PtfUsrSumVO.java
 * @Description: 用户组合概要值对象
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-7 下午3:10:37
 * @version v1.0
 */

public class PtfUsrSumVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = -7151836632277468246L;
	
	private Integer tarUid;
	
	private Integer flag;

	public Integer getTarUid() {
		return tarUid;
	}

	public void setTarUid(Integer tarUid) {
		this.tarUid = tarUid;
	}
	
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
}
