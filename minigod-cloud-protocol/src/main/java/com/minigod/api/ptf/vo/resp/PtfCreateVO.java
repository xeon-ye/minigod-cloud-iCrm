package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfCreateVO.java
 * @Description: 组合创建结果返回
 * @Copyright: © 2014 minigod
 * @Company: minigod
 * 
 * @author minigod
 * @date 2014-10-30 下午7:54:08
 * @version v1.0
 */
@TransferBean
public class PtfCreateVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@TransferID
	private Long ptfId;
	@Emoji
	private String ptfName ;
	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

	public String getPtfName() {
		return ptfName;
	}

	public void setPtfName(String ptfName) {
		this.ptfName = ptfName;
	}
}
