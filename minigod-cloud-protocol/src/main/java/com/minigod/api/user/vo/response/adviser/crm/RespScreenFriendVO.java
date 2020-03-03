package com.minigod.api.user.vo.response.adviser.crm;


import java.io.Serializable;
import java.util.List;

import com.minigod.api.user.vo.response.adviser.crm.ScreenFriendVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 获取筛选的好友返回结果集
 */

@TransferBean
public class RespScreenFriendVO   implements Serializable {

	private static final long serialVersionUID = -4023476842698514503L;

	private Integer total ; //总数量
	private Integer curPage ; //当前页数
	private Integer totalPage ; //总页数
	private Integer rowsPage ; //每页显示行数
	@TransferID
	@Emoji
	private List<ScreenFriendVO>  sfl ;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getRowsPage() {
		return rowsPage;
	}

	public void setRowsPage(Integer rowsPage) {
		this.rowsPage = rowsPage;
	}

	public List<ScreenFriendVO> getSfl() {
		return sfl;
	}

	public void setSfl(List<ScreenFriendVO> sfl) {
		this.sfl = sfl;
	}

	
}
