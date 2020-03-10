package com.minigod.account.service.impl;

import com.minigod.account.helper.JwtHelper;
import com.minigod.account.mapper.CustomDeviceMapper;
import com.minigod.account.mapper.SysAppAuthMapper;
import com.minigod.account.service.OpenAccountService;
import com.minigod.account.service.ProxyService;
import com.minigod.account.service.UserService;
import com.minigod.common.bean.BaseBeanFactory;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.CertTypeEnum;
import com.minigod.common.pojo.StaticType.CodeType;
import com.minigod.common.pojo.StaticType.MessageResource;
import com.minigod.protocol.account.enums.PasswordTypeEnum;
import com.minigod.protocol.account.model.CustomDevice;
import com.minigod.protocol.account.model.SysAppAuth;
import com.minigod.protocol.account.vo.request.params.*;
import com.minigod.protocol.account.vo.response.LoginResVo;
import com.minigod.protocol.account.vo.response.AuthProxyResVo;
import com.minigod.protocol.account.vo.response.OpenUserInfoResVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class ProxyServiceImpl extends BaseBeanFactory implements ProxyService {

    @Autowired
    SysAppAuthMapper sysAppAuthMapper;
    @Autowired
    CustomDeviceMapper customDeviceMapper;
    @Autowired
    JwtHelper jwtHelper;
    @Autowired
    UserService userService;
    @Autowired
    OpenAccountService openAccountService;

    @Override
    public AuthProxyResVo getAuthCode(AuthProxyReqParams params) {
        // 参数校验
        if (params == null) {
            log.error("参数异常: LoginReqParams");
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        String appKey = params.getAppKey();
        String appSecret = params.getSecret();
        AuthProxyReqParams.DeviceInfo deviceInfo = params.getDeviceInfo();


        // 参数校验 - 基本
        if (StringUtils.isEmpty(appKey) || StringUtils.isEmpty(appSecret) || deviceInfo == null) {
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        String deviceCode = deviceInfo.getDeviceCode();
        Byte deviceType = deviceInfo.getDeviceType();
        Byte osType = deviceInfo.getOsType();
        String appVersion = deviceInfo.getAppVersion();
        String deviceModel = deviceInfo.getDeviceModel();
        String deviceName = deviceInfo.getDeviceName();
        String osVersion = deviceInfo.getOsVersion();

        if (StringUtils.isEmpty(deviceCode) || deviceType == null || osType == null || StringUtils.isEmpty(appVersion)) {
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }


        SysAppAuth appAuthInfo = sysAppAuthMapper.selectOneByAppKeyAndDeletedFalse(appKey);

        if (appAuthInfo == null) {
            // appId不存在
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        if (!appAuthInfo.getIsEnabled()) {
            // appId被禁用
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        if (!appAuthInfo.getAppSecret().equals(appSecret)) {
            // 密钥错误
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        String authDeviceTypes = appAuthInfo.getDeviceTypes();
        String authOsTypes = appAuthInfo.getOsTypes();
        String authAppVersion = appAuthInfo.getAppVersion();

        if (StringUtils.isNotEmpty(authDeviceTypes) && authDeviceTypes.contains(deviceType.toString())) {
            // TODO:不符合设备类型限制
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);

        }

        if (StringUtils.isNotEmpty(authOsTypes) && authOsTypes.contains(osType.toString())) {
            // TODO:不符合终端类型限制
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);

        }

        if (StringUtils.isNotEmpty(authAppVersion) && !authAppVersion.equals(appVersion)) {
            // TODO:不符合版本限制
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);

        }

        CustomDevice customDevice = customDeviceMapper.selectOneByDeviceCodeAndOsType(deviceCode, osType);
        Date now = new Date();
        if (customDevice != null) {
            // 已经登记过，更新。
            if (!customDevice.getStatus()) {
                // TODO:设备被锁定
                throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
            }

            // 设备名称、版本号等可能会更新
            customDevice.setDeviceName(deviceName);
            customDevice.setOsVersion(osVersion);
            customDevice.setAppVersion(appVersion);
            customDevice.setUpdateTime(now);

            customDeviceMapper.updateByPrimaryKeySelective(customDevice);
        } else {
            customDevice = new CustomDevice();
            customDevice.setDeviceCode(deviceCode);
            customDevice.setDeviceType(deviceType);
            customDevice.setDeviceModel(deviceModel);
            customDevice.setDeviceName(deviceName);
            customDevice.setOsType(osType);
            customDevice.setOsVersion(osVersion);
            customDevice.setAppId(appAuthInfo.getId());
            customDevice.setAppVersion(appVersion);
            customDevice.setStatus(true);
            customDevice.setCreateTime(now);
            customDevice.setUpdateTime(now);
            customDeviceMapper.insertSelective(customDevice);
        }

        if (customDevice == null) {
            // TODO: 插入数据错误
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        String authCode = jwtHelper.createAuthCode(customDevice.getId());

        AuthProxyResVo authProxyResVo = new AuthProxyResVo();

        authProxyResVo.setAuthCode(authCode);

        return authProxyResVo;
    }

    @Override
    public LoginResVo proxyLogin(LoginProxyReqParams params) {
        // 参数校验
        if (params == null) {
            log.error("参数异常: LoginProxyReqParams");
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        String account = params.getAccount();
        String password = params.getPassword();

        // 参数校验 - 基本
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        LoginReqParams loginReqParams = new LoginReqParams();
        loginReqParams.setCertType(CertTypeEnum.phone.getTypeValue());
        loginReqParams.setCertCode(account);
        loginReqParams.setPasswordType(PasswordTypeEnum.other.getTypeValue());
        loginReqParams.setPassword(password);

        return userService.loginByOther(loginReqParams);
    }

    @Override
    public OpenUserInfoResVo getOpenProgress(Integer userId, OpenProgressProxyReqParams params) {
        OpenProgressReqParams openProgressReqParams = new OpenProgressReqParams();
        return openAccountService.getOpenProgress(userId, openProgressReqParams);
    }
}
