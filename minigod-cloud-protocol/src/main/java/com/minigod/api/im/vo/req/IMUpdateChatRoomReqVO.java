package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * Created by ChenYouhuo on 2016/4/28.
 */
@TransferBean
public class IMUpdateChatRoomReqVO extends SNVersion {
    private static final long serialVersionUID = 9037604946075247746L;
    @TransferID
    private IMUpdateChatRoomVO params;

    public IMUpdateChatRoomVO getParams() {
        return params;
    }

    public void setParams(IMUpdateChatRoomVO params) {
        this.params = params;
    }
}
