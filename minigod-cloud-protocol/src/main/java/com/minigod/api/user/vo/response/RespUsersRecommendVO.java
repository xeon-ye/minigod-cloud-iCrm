package com.minigod.api.user.vo.response;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ChenYouhuo on 2016/4/12.
 */

@TransferBean
public class RespUsersRecommendVO implements Serializable {

    private static final long serialVersionUID = -1538097423512752119L;
    @TransferID
    private List<RespUserRecommendVO> respUserRecomendVOs;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<RespUserRecommendVO> getRespUserRecomendVOs() {
        return respUserRecomendVOs;
    }

    public void setRespUserRecomendVOs(List<RespUserRecommendVO> respUserRecomendVOs) {
        this.respUserRecomendVOs = respUserRecomendVOs;
    }
}
