package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * Created by ChenYouhuo on 2016/6/22.
 */
public class IMGetChatRoomlistRVO extends BaseVO {
    private static final long serialVersionUID = -3798003824342633373L;
    private String assetId;
    
    private String groupType;
    
    private String memberId;
    
    public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
}
