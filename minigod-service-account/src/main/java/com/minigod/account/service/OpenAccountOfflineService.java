package com.minigod.account.service;

import com.minigod.protocol.account.cubp.callback.CubpOpenInfoCallbackVo;

public interface OpenAccountOfflineService {
    public Integer saveOrUpdateOpenInfo(CubpOpenInfoCallbackVo callbackVo);

}
