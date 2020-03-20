package com.minigod.securities.web.callback;

import com.minigod.account.service.OpenAccountService;
import com.minigod.account.service.UserService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.request.BaseRequest;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.notify.service.CaptchaSmsService;
import com.minigod.protocol.account.cubp.vo.callback.CubpOpenInfoCallbackVo;
import com.minigod.protocol.account.enums.CubpMessageResource;
import com.minigod.protocol.account.vo.request.params.LoginReqParams;
import com.minigod.protocol.account.vo.response.LoginResVo;
import com.minigod.protocol.notify.vo.request.params.CaptchaReqParams;
import com.minigod.protocol.notify.vo.response.CaptchaResVo;
import com.minigod.securities.annotation.LoginUser;
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
@RequestMapping("/callback")
public class OpenAccountCallback {
    @Autowired
    private OpenAccountService openAccountService;


    /**
     * BPM回调开户状态接口
     * @param callbackVo
     * @return
     */
    @PostMapping("/updateOpenInfo")
    public ResResult fetchCaptcha(@RequestBody CubpOpenInfoCallbackVo callbackVo) {
        try {
            openAccountService.updateOpenInfo(callbackVo);

            return ResResult.success();
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_FETCH_CAPTCHA);
        }
    }


}
