package com.minigod.security.controller;

import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.request.BaseRequest;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.notify.protocol.vo.request.params.CaptchaReqParams;
import com.minigod.notify.protocol.vo.response.CaptchaResVo;
import com.minigod.notify.service.CaptchaSmsService;
import com.minigod.security.protocol.enums.CubpMessageResource;
import com.minigod.security.protocol.vo.request.params.LoginReqParams;
import com.minigod.security.protocol.vo.response.LoginResVo;
import com.minigod.security.service.UserService;
import com.minigod.security.task.OpenAccountJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RefreshScope
@RequestMapping("/test")
public class TestController {
    @Autowired
    private OpenAccountJob openAccountJob;

    /**
     * 用户登录
     */
    @PostMapping("open_task")
    public ResResult openTask() {
        try {
            openAccountJob.executeOpenAccount();
            return ResResult.success();
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_LOGIN);
        }
    }
}
