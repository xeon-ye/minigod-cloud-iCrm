/**
 * @Title: ViewpointListVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-4 上午10:05:02
 * @version v1.0
 */
@TransferBean
public class ViewpointListVO extends BaseVO{
	private static final long serialVersionUID = 1L;

	@TransferID
	private Long uId;
	private Integer count;
	private Long readId;
	private Integer versionId;
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	public Long getuId() {
		return uId;
	}
	public void setuId(Long uId) {
		this.uId = uId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Long getReadId() {
		return readId;
	}
	public void setReadId(Long readId) {
		this.readId = readId;
	}
}
