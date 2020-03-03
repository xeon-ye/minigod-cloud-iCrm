/**
 * @Title: FtfCntVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;

/**
 * @description 用户的组合数量
 * 
 * @author panlz
 * @date 2015-5-29 下午3:26:00
 * @version v1.0
 */

@TransferBean
public class PtfCntRequestVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	/*用户id*/
	private Integer iUserId;

	public Integer getiUserId() {
		return iUserId;
	}

	public void setiUserId(Integer iUserId) {
		this.iUserId = iUserId;
	}

}
