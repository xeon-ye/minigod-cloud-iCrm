package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfUpdateNotifyVO.java
 * @Description: 跟单组合通知返回VO类
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author panlz
 * @date 2015-03-16 上午11:33:48
 * @version v1.0
 */
@TransferBean
public class PtfUpdateNotifyRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@TransferID
	@Emoji
	private List<PtfUpdateNotifyVO>  ntfs;//ntfs对象集合

	public List<PtfUpdateNotifyVO> getNtfs() {
		return ntfs;
	}

	public void setNtfs(List<PtfUpdateNotifyVO> ntfs) {
		this.ntfs = ntfs;
	}
	
	

}