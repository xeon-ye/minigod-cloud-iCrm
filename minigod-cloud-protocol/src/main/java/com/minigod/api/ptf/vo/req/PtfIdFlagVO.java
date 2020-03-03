package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfIdFlagVO.java
 * @Description: 这里描述类的用处
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-11 上午11:26:55
 * @version v1.0
 */
@TransferBean
public class PtfIdFlagVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private Long ptfId; // 组合id
	
	private Long flag; // 标志位

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

	public Long getFlag() {
		return flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}
	
}
