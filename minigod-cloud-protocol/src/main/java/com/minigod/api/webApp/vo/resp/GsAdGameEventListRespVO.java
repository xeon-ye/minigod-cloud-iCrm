/**
 * @Title: GameEventListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author panlz
 * @date 2015-9-15 下午5:17:02
 * @version v1.0
 */

@TransferBean
public class GsAdGameEventListRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private List<GameEventListVO>  gameList ; //赛事列表
	private Integer readId; // 已读到id
	private Integer hasNext; // 0-没有下一页，1-有下一页

	public List<GameEventListVO> getGameList() {
		return gameList;
	}

	public void setGameList(List<GameEventListVO> gameList) {
		this.gameList = gameList;
	}

	public Integer getReadId() {
		return readId;
	}

	public void setReadId(Integer readId) {
		this.readId = readId;
	}

	public Integer getHasNext() {
		return hasNext;
	}

	public void setHasNext(Integer hasNext) {
		this.hasNext = hasNext;
	}
}
