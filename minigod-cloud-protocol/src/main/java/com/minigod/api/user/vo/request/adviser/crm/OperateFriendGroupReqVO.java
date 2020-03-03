package com.minigod.api.user.vo.request.adviser.crm;

import java.util.List;

import com.minigod.api.user.vo.SNUserBase;

public class OperateFriendGroupReqVO  extends SNUserBase {
	private static final long serialVersionUID = 1L;
	
	private List<OperateFriendGroupVO> operateList;

	public List<OperateFriendGroupVO> getOperateList() {
		return operateList;
	}

	public void setOperateList(List<OperateFriendGroupVO> operateList) {
		this.operateList = operateList;
	}
	
}
