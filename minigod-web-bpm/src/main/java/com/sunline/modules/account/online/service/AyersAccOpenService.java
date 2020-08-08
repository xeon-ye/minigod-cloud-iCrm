package com.sunline.modules.account.online.service;

import com.sunline.modules.account.online.entity.AyersClientAccEntity;
import com.sunline.modules.account.online.entity.AyersClientInfoEntity;

public interface AyersAccOpenService {
    /**
     * 保存用户信息到柜台
     *UUID、CLIENT_ID、CREATE_USER、CREATE_TIME
     * @param infoEntity
     * @return
     */
    int saveClientInfo(AyersClientInfoEntity infoEntity);


    /**
     * 保存用户账号信息到柜台（开户）
     * UUID、CLIENT_ACC_ID、CLIENT_ID、CREATE_USER、CREATE_TIME
     * @param accEntity
     * @return
     */
    int saveClineAcc(AyersClientAccEntity accEntity);
}
