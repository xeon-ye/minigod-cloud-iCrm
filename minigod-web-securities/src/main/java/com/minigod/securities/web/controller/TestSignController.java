package com.minigod.securities.web.controller;

import com.minigod.account.service.UserService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.request.BaseRequest;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.notify.service.CaptchaSmsService;
import com.minigod.protocol.account.enums.CubpMessageResource;
import com.minigod.protocol.account.other.vo.response.OtherUserInfoResVo;
import com.minigod.protocol.account.vo.request.params.LoginReqParams;
import com.minigod.protocol.account.vo.response.LoginResVo;
import com.minigod.protocol.notify.vo.request.params.CaptchaReqParams;
import com.minigod.protocol.notify.vo.response.CaptchaResVo;
import com.minigod.securities.annotation.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RefreshScope
@RequestMapping("/test")
public class TestSignController {
    @Autowired
    private CaptchaSmsService smsService;
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @PostMapping("checkUser")
    public ResResult checkUser() {
        try {
            OtherUserInfoResVo otherUserInfoResVo = new OtherUserInfoResVo();
            otherUserInfoResVo.setIsRealUser(true);
            otherUserInfoResVo.setPhoneNumber("18938070402");
            return ResResult.success(otherUserInfoResVo);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_LOGIN);
        }
    }
}
