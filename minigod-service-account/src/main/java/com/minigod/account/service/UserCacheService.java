package com.minigod.account.service;

import com.minigod.protocol.account.model.CustomSession;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "minigod-account-service")
public interface UserCacheService {
    // 保存用户会话
    CustomSession saveCustomSession(Integer userId);

    // 保存用户会话
    void expireCustomSession(Integer userId, String token);
}
