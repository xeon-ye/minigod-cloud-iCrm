package com.minigod.api.invconns.vo;

import com.minigod.api.invconns.vo.FriInvConnsVO;

import java.util.List;

/**
 * 
 * 
 * <code>InvConnsVO.java<code>[投资人脉用户信息实体]
 * 
 * @author Colin
 * @date 2015-1-3 下午4:01:54
 * 
 */

public class InvConnsVO extends FriInvConnsVO {

	private static final long serialVersionUID = 1L;

	private List<FriInvConnsVO> list;// minigod用户排名list

	public List<FriInvConnsVO> getList() {
		return list;
	}

	public void setList(List<FriInvConnsVO> list) {
		this.list = list;
	}
}