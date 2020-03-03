/**
 * @Title: IMNewMembersReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-16 下午12:56:56
 * @version v1.0
 */
@TransferBean
public class IMAddNewMembersViaQNUserReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	@TransferID
	private IMAddNewMembersViaQNUserVO params;
	
	public IMAddNewMembersViaQNUserVO getParams() {
		return params;
	}
	public void setParams(IMAddNewMembersViaQNUserVO params) {
		this.params = params;
	}
}
