package com.minigod.securities.interceptor;

import com.alibaba.fastjson.JSON;
import com.minigod.account.helper.RedisTokenManager;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.i18n.MessageI18NHelper;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.request.BaseRequest;
import com.minigod.common.pojo.request.BaseRequestParams;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.common.security.SignUtil;
import com.minigod.common.utils.JSONUtil;
import com.minigod.securities.filter.BaseRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 签名拦截器
 *
 * @author kk
 */
@Slf4j
public class WebSignInterceptor implements HandlerInterceptor {
    @Autowired
    RedisTokenManager redisTokenManager;

    private static Set<String> noSigns = new HashSet<String>();
    private static Set<String> noTokens = new HashSet<String>();

    //不需要签名的接口
    static {
        noSigns.add("/securities/test/checkUser");
    }

    //不需要签名的接口
    static {
//        noProxySigns.add("");
    }

    //不需要验证Session的接口
    static {
        noTokens.add("/securities/test/checkUser");
        noTokens.add("/securities/sign/fetch_captcha");
        noTokens.add("/securities/sign/login");
        noTokens.add("/securities/sign/register");
        noTokens.add("/securities/proxy/auth");
        noTokens.add("/securities/proxy/login");
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("[preHandle] executing... request uri is {}", request.getRequestURI());
        if (isJson(request)) {
            // 获取json字符串
            BaseRequestWrapper requestWrapper = new BaseRequestWrapper(request);

            byte[] wrapperBody = requestWrapper.getBody();
            String body = new String(wrapperBody);
            log.info("[preHandle] json数据 : {}", body);

            checkSign(request.getRequestURI(), body, request.getHeader("X-Accept-Token"));

            //验签
//            BaseVo baseVo = JSON.parseObject(jsonParam, BaseVo.class);
//            log.info("baseVo:{}", baseVo);
////            boolean bool = SignUtil.validateSign(baseVo.getParams(), SecurityKey.AES_IV, baseVo.getPdfInfoForSign());
//            boolean bool = true;
//            if (!bool) {
//                response.reset();
//                //设置编码格式
//                response.setCharacterEncoding("UTF-8");
//                response.setContentType("application/json;charset=UTF-8");
//                PrintWriter pw = response.getWriter();
//                pw.write(JSON.toJSONString(ResponseUtil.errorSign()));
//
//                return false;
//            }
            requestWrapper.updateParams();

        }

        return true;
    }

    /**
     * 判断本次请求的数据类型是否为json
     *
     * @param request request
     * @return boolean
     */
    private boolean isJson(HttpServletRequest request) {
        if (request.getContentType() != null) {
            return request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE) ||
                    request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE);
        }

        return false;
    }

    // 内外部系统不同签名策略
    private void checkSign(String url, String body, String token) {

        Map<Object, Object> maps = JSONUtil.fromJson(body);
        if (maps != null && maps.size() > 0) {
            Object args = maps.get("params");
            if (args == null) {
                log.error("params签名参数异常.");
                throw new WebApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_ARGS);
            }

            Map<Object, Object> params = JSONUtil.fromJson(args.toString());

            // 是否需要验证签名
            if (!noSigns.contains(url)) {
                try {
                    Object sign = maps.get("sign");
                    if (sign == null) {
                        //参数错误,验证不通过
                        log.warn("无效的sign请求,参数不能为空:" + JSONUtil.toJson(maps));
                        throw new WebApiException(StaticType.CodeType.ERROR_SIGN, StaticType.MessageResource.ERROR_SIGN);
                    }
                    Object key = null;
                    // 需要校验token的接口，统一采用token作为key
                    if (!noTokens.contains(url)) {
                        key = token;
                    }
                    // 不需要需要校验token的接口（如获取验证码|登录|注册等），统一使用certCode作为key
                    else {
                        key = params.get("certCode");
                    }

                    // 签名偏移量
                    String _key = key != null ? key.toString() : null;

                    if (StringUtils.isBlank(_key)) {
                        log.error("key签名参数异常." + key + "," + params);
                        throw new WebApiException(StaticType.CodeType.BAD_PARAM_KEY, StaticType.MessageResource.BAD_PARAM_KEY);
                    }

                    String _sign = sign.toString();
                    String _args = params.toString();

                    if (!SignUtil.validateSign(SignUtil.getParams(_args), _key, _sign)) {
                        throw new WebApiException(StaticType.CodeType.ERROR_SIGN, StaticType.MessageResource.ERROR_SIGN);
                    }

                } catch (Exception e) {
                    log.warn("无效的签名参数:", e);
                    throw new WebApiException(StaticType.CodeType.ERROR_SIGN, StaticType.MessageResource.ERROR_SIGN);
                }

            }
        }
    }

//    private ResResult checkWebToken(String langKey, String url, String token) {
//        ResResult resResult = new ResResult();
//        // session校验
//        if (!noTokens.contains(url)) {
//            try {
//                if (token == null) {
//                    //参数错误,验证不通过
//                    log.warn("sessionId参数异常");
//                    resResult.setCode(StaticType.CodeType.BAD_PARAM_SESSION.getCode());
//                    resResult.setMessage(getLocaleMessage(StaticType.MessageResource.BAD_PARAM_SESSION, langKey));
//                    return resResult;
//                }
//
//                if (!redisTokenManager.checkToken(token)) {
//                    resResult.setCode(StaticType.CodeType.SESSION_INVALID.getCode());
//                    resResult.setMessage(getLocaleMessage(StaticType.MessageResource.SESSION_INVALID, langKey));
//                    return resResult;
//                }
//            } catch (Exception e) {
//                log.warn("无效的token参数:", e);
//                resResult.setCode(StaticType.CodeType.BAD_PARAM_SESSION.getCode());
//                resResult.setMessage(getLocaleMessage(StaticType.MessageResource.BAD_PARAM_SESSION, langKey));
//                return resResult;
//            }
//        }
//        return null;
//    }
//
//    private void buildErrorResponseVO(ServletResponse response, ResResult resResult) {
//
//
//        String json = com.alibaba.fastjson.JSONObject.toJSONString(resResult);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//            out.append(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                out.close();
//            }
//        }
//    }
//
//
//    public String getLocaleMessage(String messageResource, String langKey) {
//        return messageI18NHelper.getLocaleMessage(langKey, messageResource);
//    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) {

    }

}
