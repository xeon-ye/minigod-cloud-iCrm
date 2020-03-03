package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class UserTelContact extends SNUserBase {

	private static final long serialVersionUID = -8973605427918040551L;

	private Integer action; //拉取数据的方式，0表示拉取更新，1表示拉取更多数据
	private Integer count; //拉取数量
	private Integer status; //返回给后端，供后端用, action=0可不传
	private Integer contId; //服务器根据此ID来判断接下来该给哪些数据, action=0可不传

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getContId() {
		return contId;
	}

	public void setContId(Integer contId) {
		this.contId = contId;
	}
}