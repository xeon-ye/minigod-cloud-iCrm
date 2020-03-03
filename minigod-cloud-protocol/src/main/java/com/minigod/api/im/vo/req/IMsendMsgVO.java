package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

import java.util.List;

/**
 * Created by ChenYouhuo on 2016/4/22.
 */
@TransferBean
public class IMsendMsgVO extends BaseVO {
    private static final long serialVersionUID = -4196303416038192093L;
    @TransferID
    private Long fromUserId;
    private Integer toType;//0全站，1个人
    @TransferID
    private List<Long> toUserIds;
    private String msg;

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToType() {
        return toType;
    }

    public void setToType(Integer toType) {
        this.toType = toType;
    }

    public List<Long> getToUserIds() {
        return toUserIds;
    }

    public void setToUserIds(List<Long> toUserIds) {
        this.toUserIds = toUserIds;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
