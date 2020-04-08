package com.minigod.securities.web.callback;

import com.minigod.account.service.OpenAccountOnlineService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.protocol.account.cubp.callback.CubpOpenInfoCallbackVo;
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
    private OpenAccountOnlineService openAccountOnlineService;


    /**
     * BPM回调开户状态接口
     *
     * @param callbackVo
     * @return
     */
    @PostMapping("/update_open_info")
    public ResResult fetchCaptcha(@RequestBody CubpOpenInfoCallbackVo callbackVo) {
        try {
            openAccountOnlineService.updateOpenInfo(callbackVo);

            return ResResult.success();
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_FETCH_CAPTCHA);
        }
    }

}
