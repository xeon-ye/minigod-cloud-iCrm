package com.minigod.helper.handler;

import com.minigod.common.constant.Const;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.helper.i18n.MessageI18NHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @Resource
    MessageI18NHelper messageI18NHelper;

    /**
     * 外部接口服务异常统一处理方法，
     * 返回httpStatus 200
     * 返回数据 ResResult {code: [错误码], message: [错误信息]}
     */
    @ExceptionHandler(WebApiException.class)
    @ResponseBody
    public ResResult processApiException(HttpServletRequest request, HttpServletResponse response, WebApiException e) {
        String localeStr = request.getHeader(Const.H5_LANGUAGE_KEY);
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=UTF-8");
        ResResult result = new ResResult();
        result.setCode(e.getCode());
        result.setMessage(messageI18NHelper.getLocaleMessage(localeStr, e.getMessageResource()));
        return result;
    }


    /**
     * 内部微服务异常统一处理方法
     * 返回httpStatus [错误码]
     * 返回数据 ResResult {code: [错误码], message: [错误信息]}
     */
    @ExceptionHandler(InternalApiException.class)
    @ResponseBody
    public ResResult processMicroServiceException(HttpServletResponse response, InternalApiException e) {
        ResResult result = new ResResult();
        response.setStatus(e.getCode());
        response.setContentType("application/json;charset=UTF-8");
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        return result;
    }
}
