package com.minigod.api.user.vo.response;

import java.io.Serializable;
import java.util.List;

public class RespUserInvitations implements Serializable {

	private static final long serialVersionUID = 4543680708525375371L;

	private List<InvitationVO> invitations;

	public List<InvitationVO> getInvitations() {
		return invitations;
	}

	public void setInvitations(List<InvitationVO> invitations) {
		this.invitations = invitations;
	}
	
	public RespUserInvitations() {
		super();
	}

	public RespUserInvitations(List<InvitationVO> invitations) {
		super();
		this.invitations = invitations;
	}
}
