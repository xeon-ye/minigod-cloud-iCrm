package com.minigod.api.user.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
@TransferBean
public class RespTelContactTfsVO implements Serializable {

	private static final long serialVersionUID = 3176672955281189535L;
	@TransferID
	private List<RespTelContactVO>  tfs;//tfs对象集合

	public List<RespTelContactVO> getTfs() {
		return tfs;
	}

	public void setTfs(List<RespTelContactVO> tfs) {
		this.tfs = tfs;
	}
}
