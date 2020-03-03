/**
 * @Title: ViewpointInteractionVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-3 下午5:10:56
 * @version v1.0
 */
@TransferBean
public class ViewpointInteractionVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private String type;
	private Long viewpointId;
	@TransferID
	private Long toUId;
	@Emoji
	private String content;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getViewpointId() {
		return viewpointId;
	}
	public void setViewpointId(Long viewpointId) {
		this.viewpointId = viewpointId;
	}
	public Long getToUId() {
		return toUId;
	}
	public void setToUId(Long toUId) {
		this.toUId = toUId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
