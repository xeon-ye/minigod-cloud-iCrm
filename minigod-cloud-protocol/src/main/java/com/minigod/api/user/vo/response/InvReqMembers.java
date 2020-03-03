package com.minigod.api.user.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.user.vo.params.RespInvReqMembers;

public class InvReqMembers implements Serializable {

	private static final long serialVersionUID = -7481778098542998568L;

	private List<RespInvReqMembers> users;

	public List<RespInvReqMembers> getUsers() {
		return users;
	}

	public void setUsers(List<RespInvReqMembers> users) {
		this.users = users;
	}

	public InvReqMembers() {
		super();
	}

	public InvReqMembers(List<RespInvReqMembers> users) {
		super();
		this.users = users;
	}
}
