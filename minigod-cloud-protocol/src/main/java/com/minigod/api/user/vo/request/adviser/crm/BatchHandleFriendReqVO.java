package com.minigod.api.user.vo.request.adviser.crm;

import java.util.List;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class BatchHandleFriendReqVO extends SNUserBase {
	private static final long serialVersionUID = 1827960851264866186L;
	private Integer resp;// 0表示拒绝请求，1表示同意请求。
	@TransferID
	private List<Long> tarUserIds;//目标用户ID集

	public Integer getResp() {
		return resp;
	}

	public void setResp(Integer resp) {
		this.resp = resp;
	}

	public List<Long> getTarUserIds() {
		return tarUserIds;
	}

	public void setTarUserIds(List<Long> tarUserIds) {
		this.tarUserIds = tarUserIds;
	}
	
}