package com.minigod.securities.web.controller;

import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.protocol.account.other.response.OtherUserInfoResVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RefreshScope
@RequestMapping("/test")
public class TestSignController {

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
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_LOGIN);
        }
    }

}
