package com.minigod.account.service;

import com.minigod.protocol.account.bpm.callback.BpmOpenInfoCallbackVo;

public interface OpenAccountOfflineService {
    public Integer saveOrUpdateOpenInfo(BpmOpenInfoCallbackVo callbackVo);

}
