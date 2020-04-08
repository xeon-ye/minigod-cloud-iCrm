package com.minigod.securities.web.controller;

import com.minigod.common.pojo.response.ResResult;
import com.minigod.protocol.account.request.params.LogoutParams;
import com.minigod.protocol.notify.request.params.CaptchaReqParams;
import com.minigod.protocol.notify.response.CaptchaResVo;
import com.minigod.notify.service.CaptchaSmsService;
import com.minigod.securities.annotation.LoginUser;
import com.minigod.protocol.account.request.params.LoginReqParams;
import com.minigod.protocol.account.response.LoginResVo;
import com.minigod.account.service.UserService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.request.BaseRequest;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RefreshScope
@RequestMapping("/sign")
public class SignController {
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
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_FETCH_CAPTCHA);
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
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_LOGIN);
        }
    }

    /**
     * 用户登录
     */
    @PostMapping("logout")
    public ResResult logout(@LoginUser Integer userId, @RequestBody BaseRequest<LogoutParams> requestVo) {
        try {
            LogoutParams params = requestVo.getParams();
           userService.logout(userId, params);
            return ResResult.success();
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_LOGIN);
        }
    }
}
