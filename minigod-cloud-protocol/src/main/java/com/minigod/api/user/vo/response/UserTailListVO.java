/**
 * @Title: UserTailListVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.user.vo.response.UserTailVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-12 上午10:50:52
 * @version v1.0
 */
@TransferBean
public class UserTailListVO implements Serializable{
	/** */
	private static final long serialVersionUID = 1L;
	@TransferID
	private List<UserTailVO> data;
	
	public List<UserTailVO> getData() {
		return data;
	}
	public void setData(List<UserTailVO> data) {
		this.data = data;
	}
}
