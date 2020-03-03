package com.minigod.api.ptf.vo.req;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfFavVo.java
 * @Description: 收藏的组合增删请求值对象
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-18 下午2:46:37
 * @version v1.0
 */
@TransferBean
public class PtfFavVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer action; // 操作类型：0删除；1新增
	
	@TransferID
	private List<Long> ptfIds; // 收藏的组合id集合
	
	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public List<Long> getPtfIds() {
		return ptfIds;
	}

	public void setPtfIds(List<Long> ptfIds) {
		this.ptfIds = ptfIds;
	}

}
