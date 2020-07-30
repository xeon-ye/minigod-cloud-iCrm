package com.minigod.account.service;

import com.minigod.protocol.account.request.params.LoginReqParams;
import com.minigod.protocol.account.request.params.LogoutParams;
import com.minigod.protocol.account.request.params.RetisterReqParams;
import com.minigod.protocol.account.response.LoginResVo;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@FeignClient(value = "minigod-account-service")
public interface UserService {

    @PostMapping("/login")
    public LoginResVo login(LoginReqParams loginReqParams);

    @PostMapping("/login_other")
    public LoginResVo loginByOther(LoginReqParams loginReqParams);

    @PostMapping("/register")
    public LoginResVo register(RetisterReqParams retisterReqParams);

    @PostMapping("/logout")
    public void logout(Integer userId, LogoutParams logoutParams);
}
