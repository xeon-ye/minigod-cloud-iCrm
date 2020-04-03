package com.minigod.securities.web.proxy;

import com.minigod.account.service.ProxyService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.protocol.account.response.LoginResVo;
import com.minigod.protocol.account.response.OpenUserInfoResVo;
import com.minigod.protocol.account.request.ProxyBaseRequest;
import com.minigod.protocol.account.request.params.OpenProgressProxyReqParams;
import com.minigod.protocol.account.request.params.AuthProxyReqParams;
import com.minigod.protocol.account.request.params.LoginProxyReqParams;
import com.minigod.protocol.account.response.AuthProxyResVo;
import com.minigod.securities.annotation.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 外部系统调用接口
 */
@Slf4j
@RestController
@RefreshScope
@RequestMapping("/proxy")
public class AccountServiceProxy {
    @Autowired
    private ProxyService proxyService;

    /**
     * 平台鉴权
     */
    // TODO：采集设备信息、ip、产品等数据，返回平台鉴权key
    @PostMapping("auth")
    public ResResult auth(@RequestBody ProxyBaseRequest<AuthProxyReqParams> requestVo) {
        try {
            AuthProxyReqParams params = requestVo.getParams();
            AuthProxyResVo authProxyResVo = proxyService.getAuthCode(params);
            return ResResult.success(authProxyResVo);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_LOGIN);
        }
    }

    /**
     * 登录
     */
    @PostMapping("login")
    public ResResult sign(@RequestBody ProxyBaseRequest<LoginProxyReqParams> requestVo) {
        try {
            LoginProxyReqParams params = requestVo.getParams();
            LoginResVo resVo = proxyService.proxyLogin(params);
            return ResResult.success(resVo);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_LOGIN);
        }
    }

    /**
     * 获取客户开户进度
     */
    @PostMapping("get_account_status")
    public ResResult getAccountStatus(@LoginUser Integer userId, @RequestBody ProxyBaseRequest<OpenProgressProxyReqParams> requestVo) {
        try {
            OpenProgressProxyReqParams params = requestVo.getParams();
            OpenUserInfoResVo resVo = proxyService.getOpenProgress(userId, params);
            return ResResult.success(resVo);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_LOGIN);
        }
    }

}
