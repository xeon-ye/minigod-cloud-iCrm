package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * Created by ChenYouhuo on 2016/4/22.
 */
@TransferBean
public class IMsendMsgReqVO extends SNVersion {

    private static final long serialVersionUID = -6838200451007299600L;
    @TransferID
    private IMsendMsgVO params;

    public IMsendMsgVO getParams() {
        return params;
    }

    public void setParams(IMsendMsgVO params) {
        this.params = params;
    }
}
