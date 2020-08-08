package com.minigod.account.service;

import com.minigod.protocol.account.bpm.callback.BpmOpenInfoCallbackVo;
import com.minigod.protocol.account.request.params.*;

//import org.springframework.cloud.netflix.feign.FeignClient;

//@FeignClient(value = "minigod-account-service")
public interface OpenMoreAccountService {
    public void saveOrUpdate(Integer userId, OpenMoreAccountReqParams params);

    public void updateByBpm(BpmOpenInfoCallbackVo callbackVo);
}
