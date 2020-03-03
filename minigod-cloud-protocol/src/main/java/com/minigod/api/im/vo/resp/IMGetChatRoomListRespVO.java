/**
 * @Title: IMFetchGroupListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import com.minigod.common.anno.TransferBean;

import java.io.Serializable;
import java.util.List;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-21 下午3:53:10
 * @version v1.0
 */
@TransferBean
public class IMGetChatRoomListRespVO implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;
	private List<IMGetChatRoomListVO> chatRoomList;

	public List<IMGetChatRoomListVO> getChatRoomList() {
		return chatRoomList;
	}

	public void setChatRoomList(List<IMGetChatRoomListVO> chatRoomList) {
		this.chatRoomList = chatRoomList;
	}
}
