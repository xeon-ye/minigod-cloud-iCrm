package com.minigod.security.filter;

import com.minigod.common.utils.JSONUtil;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.security.helper.RedisTokenManager;
import com.minigod.security.protocol.constant.SecurityConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.OPTIONS;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Slf4j
//@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Autowired
    RedisTokenManager redisTokenManager;

    private static Set<String> noSigns = new HashSet<String>();
    private static Set<String> noSessions = new HashSet<String>();

    //不需要签名的接口
    static {
        noSigns.add("/security/test/open_task");
    }

    //不需要验证Session的接口
    static {
        noSessions.add("/security/test/open_task");
        noSessions.add("/security/auth/fetch_captcha");
        noSessions.add("/security/auth/login");
        noSessions.add("/security/auth/register");
    }

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("StreamFilter初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getMethod().equals(HttpMethod.OPTIONS.toString())) {
            filterChain.doFilter(request, response);
            return;
        }

        BaseRequestWrapper requestWrapper = new BaseRequestWrapper(request);

        byte[] wrapperBody = requestWrapper.getBody();
        String body = new String(wrapperBody);

        ResResult resResult = null;
        String url = request.getRequestURI();

        if (url.contains("/storage/file")) {
            filterChain.doFilter(requestWrapper, response);
            return;
        }

        // 签名校验
        Map<Object, Object> maps = JSONUtil.fromJson(body);
        if (maps != null && maps.size() > 0) {
            resResult = checkSign(url, maps);
            if (resResult != null) {
                buildErrorResponseVO(response, resResult);
                filterChain.doFilter(requestWrapper, response);
                return;
            }

        }

        // session校验
        String token = request.getHeader(SecurityConst.H5_TOKEN_KEY);
        resResult = checkToken(url, token);
        if (resResult != null) {
            buildErrorResponseVO(response, resResult);
            filterChain.doFilter(requestWrapper, response);
            return;
        }

        filterChain.doFilter(requestWrapper, response);
    }

    private ResResult checkSign(String url, Map<Object, Object> maps) {
        ResResult resResult = new ResResult();
        // 签名校验
        if (!noSigns.contains(url)) {
            try {
                Object sign = maps.get("sign");
                if (sign == null) {
                    //参数错误,验证不通过
                    log.warn("无效的sign请求,参数不能为空:" + JSONUtil.toJson(maps));
                    resResult.setCode(StaticType.CodeType.ERROR_SIGN.getCode());
                    resResult.setMessage(StaticType.CodeType.ERROR_SIGN.getMessage());
                    return resResult;
                }
                // TODO: 签名校验
            } catch (Exception e) {
                log.warn("无效的签名参数:", e);
                resResult.setCode(StaticType.CodeType.ERROR_SIGN.getCode());
                resResult.setMessage(StaticType.CodeType.ERROR_SIGN.getMessage());
                return resResult;
            }
        }
        return null;
    }

    private ResResult checkToken(String url, String token) {
        ResResult resResult = new ResResult();
        // session校验
        if (!noSessions.contains(url)) {
            try {
                if (token == null) {
                    //参数错误,验证不通过
                    log.warn("sessionId参数异常");
                    resResult.setCode(StaticType.CodeType.BAD_PARAM_SESSION.getCode());
                    resResult.setMessage(StaticType.CodeType.BAD_PARAM_SESSION.getMessage());
                    return resResult;
                }

                if (!redisTokenManager.checkToken(token)) {
                    resResult.setCode(StaticType.CodeType.SESSION_INVALID.getCode());
                    resResult.setMessage(StaticType.CodeType.SESSION_INVALID.getMessage());
                    return resResult;
                }
            } catch (Exception e) {
                log.warn("无效的签名参数:", e);
                resResult.setCode(StaticType.CodeType.SESSION_INVALID.getCode());
                resResult.setMessage(StaticType.CodeType.SESSION_INVALID.getMessage());
                return resResult;
            }
        }
        return null;
    }

    private Object getKey(Map<Object, Object> maps) {
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

    @Override
    public void destroy() {
        log.info("StreamFilter销毁...");
    }
}
