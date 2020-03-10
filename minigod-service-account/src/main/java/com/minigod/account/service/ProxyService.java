package com.minigod.account.service;

import com.minigod.protocol.account.vo.response.LoginResVo;
import com.minigod.protocol.account.vo.response.OpenUserInfoResVo;
import com.minigod.protocol.account.vo.request.params.OpenProgressProxyReqParams;
import com.minigod.protocol.account.vo.request.params.AuthProxyReqParams;
import com.minigod.protocol.account.vo.request.params.LoginProxyReqParams;
import com.minigod.protocol.account.vo.response.AuthProxyResVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "minigod-account-service")
public interface ProxyService {

    @PostMapping("/proxy_get_auth_code")
    public AuthProxyResVo getAuthCode(AuthProxyReqParams params);

    @PostMapping("/proxy_login")
    public LoginResVo proxyLogin(LoginProxyReqParams params);

    @PostMapping("/proxy_get_open_progress")
    public OpenUserInfoResVo getOpenProgress(Integer userId, OpenProgressProxyReqParams params);

}
