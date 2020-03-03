package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfUpdateRequestVO.java
 * @Description: 这里描述类的用处
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-11 下午3:38:49
 * @version v1.0
 */
@TransferBean
public class PtfUpdateRequestVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	@TransferID
	@Emoji
	private PtfUpdateVO params;

	public PtfUpdateVO getParams() {
		return params;
	}

	public void setParams(PtfUpdateVO params) {
		this.params = params;
	}

}
