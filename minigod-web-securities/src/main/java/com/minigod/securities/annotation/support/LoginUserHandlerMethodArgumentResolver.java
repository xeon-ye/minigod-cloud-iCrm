package com.minigod.securities.annotation.support;

import com.minigod.securities.annotation.LoginUser;
import com.minigod.account.helper.RedisTokenManager;
import com.minigod.protocol.account.constant.SecuritiesConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    RedisTokenManager redisTokenManager;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(Integer.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container, NativeWebRequest request, WebDataBinderFactory factory) throws Exception {

        String token = request.getHeader(SecuritiesConst.H5_TOKEN_KEY);
        if (token == null || token.isEmpty()) {
            return null;
        }

        return redisTokenManager.getUserId(token);
    }
}
