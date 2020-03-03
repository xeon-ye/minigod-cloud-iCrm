package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfFavRequestVO.java
 * @Description: 收藏的组合请求值对象
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-18 下午2:44:30
 * @version v1.0
 */
@TransferBean
public class PtfFavRequestVO extends SNVersion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private PtfFavVO params;

	public PtfFavVO getParams() {
		return params;
	}

	public void setParams(PtfFavVO params) {
		this.params = params;
	}

}
