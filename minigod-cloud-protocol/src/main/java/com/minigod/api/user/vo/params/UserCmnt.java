package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

@TransferBean
public class UserCmnt extends SNUserBase {

	private static final long serialVersionUID = -6148586421924205449L;

	@Emoji
	private String cmnt; // 备注名
	private String relationType; // 关系类型  1：好友关系 2:自媒体/粉丝关系

	public String getCmnt() {
		return cmnt;
	}

	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	
	
}
