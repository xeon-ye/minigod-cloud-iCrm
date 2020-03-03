package com.minigod.security.service;

import com.minigod.security.protocol.model.CustomSession;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "minigod-security-service")
public interface UserCacheService {
    // 保存用户会话
    CustomSession saveCustomSession(Integer userId);
}
