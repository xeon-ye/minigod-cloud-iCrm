package com.minigod.securities.web.controller;


import com.minigod.account.service.OpenAccountOnlineService;
import com.minigod.account.service.OpenMoreAccountService;
import com.minigod.account.service.VerifyService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.request.BaseRequest;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.protocol.account.request.params.*;
import com.minigod.protocol.account.response.OpenUserInfoResVo;
import com.minigod.protocol.account.response.VerifyResVo;
import com.minigod.securities.annotation.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/open_api_more")
@Validated
@Slf4j
public class OpenMoreAccountController {
    @Autowired
    private OpenMoreAccountService openMoreAccountService;

    /**
     * 提交开户
     */
    @PostMapping("/submit_data")
    public ResResult submitOpenInfo(@LoginUser Integer userId, @RequestBody BaseRequest<OpenMoreAccountReqParams> requestVo) {
        try {
            OpenMoreAccountReqParams params = requestVo.getParams();
            openMoreAccountService.saveOrUpdate(userId, params);
            return ResResult.success();
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_SUBMIT_OPEN_INFO);
        }
    }
}
