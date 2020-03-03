package com.minigod.security.controller;

import com.minigod.common.pojo.response.ResResult;
import com.minigod.notify.protocol.vo.request.params.CaptchaReqParams;
import com.minigod.notify.protocol.vo.response.CaptchaResVo;
import com.minigod.notify.service.CaptchaSmsService;
import com.minigod.security.annotation.LoginUser;
import com.minigod.security.protocol.enums.CubpMessageResource;
import com.minigod.security.protocol.vo.request.params.LoginReqParams;
import com.minigod.security.protocol.vo.response.LoginResVo;
import com.minigod.security.service.UserService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.request.BaseRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RefreshScope
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private CaptchaSmsService smsService;
    @Autowired
    private UserService userService;

    /**
     * 获取验证码
     */
    @PostMapping("/fetch_captcha")
    public ResResult fetchCaptcha(@LoginUser Integer userId, @RequestBody BaseRequest<CaptchaReqParams> requestVo) {
        try {
            CaptchaReqParams params = requestVo.getParams();
            CaptchaResVo rt = smsService.saveCaptcha(params);
            return ResResult.success(rt);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_FETCH_CAPTCHA);
        }
    }


    /**
     * 用户登录
     */
    @PostMapping("login")
    public ResResult login(@RequestBody BaseRequest<LoginReqParams> requestVo) {
        try {
            LoginReqParams params = requestVo.getParams();
            LoginResVo rt = userService.login(params);
            return ResResult.success(rt);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_LOGIN);
        }
    }

    /**
     * 用户登录
     */
    @PostMapping("login_by_captcha")
    public ResResult loginByCaptcha(@RequestBody BaseRequest<LoginReqParams> requestVo) {
        try {
            LoginReqParams params = requestVo.getParams();
            LoginResVo rt = userService.login(params);
            return ResResult.success(rt);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_LOGIN);
        }
    }
}
