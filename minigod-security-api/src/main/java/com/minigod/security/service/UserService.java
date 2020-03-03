package com.minigod.security.service;

        import com.minigod.security.protocol.vo.request.params.LoginReqParams;
        import com.minigod.security.protocol.vo.request.params.RetisterReqParams;
        import com.minigod.security.protocol.vo.response.LoginResVo;
        import org.springframework.cloud.netflix.feign.FeignClient;
        import org.springframework.web.bind.annotation.*;

@FeignClient(value = "minigod-security-service")
public interface UserService {
    @PostMapping("/login")
    public LoginResVo login(LoginReqParams loginReqParams);

    @PostMapping("/register")
    public LoginResVo register(RetisterReqParams retisterReqParams);
}
