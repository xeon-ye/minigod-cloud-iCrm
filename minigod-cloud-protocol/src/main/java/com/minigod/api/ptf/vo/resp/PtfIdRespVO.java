package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class PtfIdRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer perm;
	
	@TransferID
	private List<Long> uIds;
	
	public Integer getPerm() {
		return perm;
	}
	
	public void setPerm(Integer perm) {
		this.perm = perm;
	}
	
	
	public List<Long> getuIds() {
		return uIds;
	}
	
	public void setuIds(List<Long> uIds) {
		this.uIds = uIds;
	}

	
	
}
