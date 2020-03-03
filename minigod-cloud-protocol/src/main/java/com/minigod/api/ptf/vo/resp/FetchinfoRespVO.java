package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class FetchinfoRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@TransferID
	@Emoji
	private List<PtfFlagDetailsVO> ptfs;

	public List<PtfFlagDetailsVO> getPtfs() {
		return ptfs;
	}

	public void setPtfs(List<PtfFlagDetailsVO> ptfs) {
		this.ptfs = ptfs;
	}
}
