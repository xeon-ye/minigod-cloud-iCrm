package com.minigod.securities.filter;

import com.minigod.common.exception.WebApiException;
import com.minigod.common.i18n.MessageI18NHelper;
import com.minigod.common.security.SignUtil;
import com.minigod.common.utils.JSONUtil;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.account.helper.RedisTokenManager;
import com.minigod.protocol.account.constant.SecuritiesConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * 内部web系统接口过滤器
 */
@Slf4j
public class WebFilter implements Filter {
    @Autowired
    RedisTokenManager redisTokenManager;
    @Autowired
    MessageI18NHelper messageI18NHelper;

    private static Set<String> noSigns = new HashSet<String>();
    private static Set<String> noProxySigns = new HashSet<String>();
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
    public void init(FilterConfig filterConfig) {
        log.info("StreamFilter初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.getSession();
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie, X-Accept-Token, X-Accept-Language");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Content-type", "application/json");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");

        if (request.getMethod().equals(HttpMethod.OPTIONS.toString())) {
            filterChain.doFilter(request, response);
            return;
        }

        ResResult resResult = new ResResult();
        BaseRequestWrapper requestWrapper = new BaseRequestWrapper(request);


        byte[] wrapperBody = requestWrapper.getBody();
        String body = new String(wrapperBody);

        String url = request.getRequestURI();

        // 读取文件接口，不受限制
        if (url.startsWith("/storage/file")) {
            filterChain.doFilter(requestWrapper, response);
            return;
        }

        // 回调接口
        // TODO: 限制ip
        if (url.startsWith("/securities/callback")) {
            filterChain.doFilter(requestWrapper, response);
            return;
        }

        String langKey = requestWrapper.getLanguage();

        if (StringUtils.isEmpty(langKey)) {
            log.error("未指定语言环境");
            resResult.setCode(StaticType.CodeType.BAD_PARAMS.getCode());
            resResult.setMessage(getLocaleMessage(StaticType.MessageResource.BAD_PARAMS, langKey));
            buildErrorResponseVO(response, resResult);
            return;
        }

        String token = request.getHeader(SecuritiesConst.H5_TOKEN_KEY);

        // 校验签名
        resResult = checkSign(langKey, url, body, token);

        // 签名通过，校验token
        if (resResult == null) {
            // 校验token
            resResult = checkWebToken(langKey, url, token);
        }

        // 存在错误信息，直接退回
        if (resResult != null) {
            buildErrorResponseVO(response, resResult);
            return;
        }

        requestWrapper.updateParams();
        filterChain.doFilter(requestWrapper, response);
    }

    // 内外部系统不同签名策略
    private ResResult checkSign(String langKey, String url, String body, String token) {
        // 是否外部系统接口
        Boolean isProxy = url.startsWith("/securities/proxy");

        Map<Object, Object> maps = JSONUtil.fromJson(body);
        ResResult resResult = new ResResult();

        if (maps != null && maps.size() > 0) {
            Object args = maps.get("params");

            if (args == null) {
                log.error("params签名参数异常.");
                resResult.setCode(StaticType.CodeType.BAD_ARGS.getCode());
                resResult.setMessage(getLocaleMessage(StaticType.MessageResource.BAD_ARGS, langKey));
                return resResult;
            }

            // 是否需要验证签名
            Boolean isNotCheck = isProxy ? noProxySigns.contains(url) : noSigns.contains(url);
            Map<Object, Object> params = JSONUtil.fromJson(args.toString());

            // 签名校验
            if (!isNotCheck) {
                try {
                    Object sign = maps.get("sign");
                    if (sign == null) {
                        //参数错误,验证不通过
                        log.warn("无效的sign请求,参数不能为空:" + JSONUtil.toJson(maps));
                        resResult.setCode(StaticType.CodeType.ERROR_SIGN.getCode());
                        resResult.setMessage(getLocaleMessage(StaticType.MessageResource.ERROR_SIGN, langKey));
                        return resResult;
                    }
                    Object key = null;
                    // 外部系统接口签名key
                    if (isProxy) {
                        // 授权认证
                        if (url.indexOf("/proxy/auth") > -1) {
                            Object secret = params.get("secret");
                            if (secret == null) {
                                log.error("外部系统授权错误.");
                                resResult.setCode(StaticType.CodeType.BAD_PROXY_SECRET.getCode());
                                resResult.setMessage(getLocaleMessage(StaticType.MessageResource.BAD_PROXY_SECRET, langKey));
                                return resResult;
                            }
                            key = secret;
                        }
                        // 外部系统除授权接口外，统一使用授权码作为key
                        else {
                            key = maps.get("authCode");
                        }
                    }
                    // 内部系统接口签名key
                    else {
                        // 需要校验token的接口，统一采用token作为key
                        if (!noTokens.contains(url)) {
                            key = token;
                        }
                        // 不需要需要校验token的接口（如获取验证码|登录|注册等），统一使用certCode作为key
                        else {
                            key = params.get("certCode");
                        }
                    }

                    //签名偏移量
                    String _key = key != null ? key.toString() : null;

                    if (StringUtils.isBlank(_key)) {
                        log.error("key签名参数异常." + key + "," + params);
                        resResult.setCode(StaticType.CodeType.BAD_PARAM_KEY.getCode());
                        resResult.setMessage(getLocaleMessage(StaticType.MessageResource.BAD_PARAM_KEY, langKey));
                        return resResult;
                    }

                    String _sign = sign.toString();
                    String _args = args.toString();

                    // 签名校验
                    if (!SignUtil.validateSign(SignUtil.getParams(_args), _key, _sign)) {
                        log.error("签名错误参数:" + _key + ">>>" + _args + ">>>" + _sign);
                        resResult.setCode(StaticType.CodeType.ERROR_SIGN.getCode());
                        resResult.setMessage(getLocaleMessage(StaticType.MessageResource.ERROR_SIGN, langKey));
                        return resResult;
                    }
                } catch (Exception e) {
                    log.warn("无效的签名参数:", e);
                    resResult.setCode(StaticType.CodeType.ERROR_SIGN.getCode());
                    resResult.setMessage(getLocaleMessage(StaticType.MessageResource.ERROR_SIGN, langKey));
                    return resResult;
                }
            }
        }
        return null;
    }

    private ResResult checkWebToken(String langKey, String url, String token) {
        ResResult resResult = new ResResult();
        // session校验
        if (!noTokens.contains(url)) {
            try {
                if (token == null) {
                    //参数错误,验证不通过
                    log.warn("sessionId参数异常");
                    resResult.setCode(StaticType.CodeType.BAD_PARAM_SESSION.getCode());
                    resResult.setMessage(getLocaleMessage(StaticType.MessageResource.BAD_PARAM_SESSION, langKey));
                    return resResult;
                }

                if (!redisTokenManager.checkToken(token)) {
                    resResult.setCode(StaticType.CodeType.SESSION_INVALID.getCode());
                    resResult.setMessage(getLocaleMessage(StaticType.MessageResource.SESSION_INVALID, langKey));
                    return resResult;
                }
            } catch (Exception e) {
                log.warn("无效的token参数:", e);
                resResult.setCode(StaticType.CodeType.BAD_PARAM_SESSION.getCode());
                resResult.setMessage(getLocaleMessage(StaticType.MessageResource.BAD_PARAM_SESSION, langKey));
                return resResult;
            }
        }
        return null;
    }

    private void buildErrorResponseVO(ServletResponse response, ResResult resResult) {


        String json = com.alibaba.fastjson.JSONObject.toJSONString(resResult);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }


    public String getLocaleMessage(String messageResource, String langKey) {
        return messageI18NHelper.getLocaleMessage(langKey, messageResource);
    }

    @Override
    public void destroy() {
        log.info("StreamFilter销毁...");
    }
}
