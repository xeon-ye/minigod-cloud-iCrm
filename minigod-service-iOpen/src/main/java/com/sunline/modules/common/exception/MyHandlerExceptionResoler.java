package com.sunline.modules.common.exception;

import com.sunline.modules.common.utils.JsonUtil;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.WebUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description: 全局异常捕获器，自定义异常
 * 用于处理在请求映射和请求处理过程中抛出的异常的类，都要实现HandlerExceptionResolver接口
 * @author: Larry Lai
 * @date: 2018/8/15 15:05
 * @version: v1.0
 */

@ControllerAdvice
public class MyHandlerExceptionResoler implements HandlerExceptionResolver {
    private static Logger logger = LoggerFactory.getLogger(MyHandlerExceptionResoler.class);

    /**
     * 当Controller层出现异常之后就会进入到这个方法resolveException
     *
     * @param request
     * @param response
     * @param o
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {

        ModelAndView mv = new ModelAndView();

        // 如果请求是Ajax 返回json格式
        if (WebUtils.isAjax(request)) {
            try {

                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                //为了系统安全,只让用户看自定义异常错误信息
                if (e instanceof MyException) {
                    logger.info("[" + request.getServletPath() + "]Ajax请求，发生业务错误，错误信息：" + e.getMessage());
                    Result error = Result.error(e.getMessage());
                    writer.write(JsonUtil.getJsonByObj(error));
                } else if (e instanceof UnauthorizedException) {
                    logger.info("[" + request.getServletPath() + "]Ajax请求，发生系统错误，错误信息：" + e.getMessage());
                    Result error = Result.error("对不起，没有权限操作！");
                    writer.write(JsonUtil.getJsonByObj(error));
                } else if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
                    logger.info("[" + request.getServletPath() + "]Ajax请求，发生404错误，错误信息：" + e.getMessage());
                    Result error = Result.error("应用程序找不到页面(404)");
                    writer.write(JsonUtil.getJsonByObj(error));
                } else {
                    logger.info("[" + request.getServletPath() + "]Ajax请求，发生系统错误，错误信息：" + e.getMessage());
                    Result error = Result.error("系统异常，请联系技术人员！");
                    writer.write(JsonUtil.getJsonByObj(error));
                }
                writer.flush();
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            // 如果不是Ajax，jsp格式返回
            Result result = null;
            if (e instanceof MyException) {
                logger.info("[" + request.getServletPath() + "]非Ajax请求，发生业务错误，错误信息：" + e.getMessage());
                result = Result.error(e.getMessage());
            } else if (e instanceof UnauthorizedException) {
                logger.info("[" + request.getServletPath() + "]Ajax请求，发生系统错误，错误信息：" + e.getMessage());
                result = Result.error("对不起，没有权限操作！");
            } else {
                logger.info("[" + request.getServletPath() + "]非Ajax请求，发生系统错误，错误信息：" + e.getMessage());
                result = Result.error("系统异常，请联系技术人员！");
            }

            // 打印堆栈日志到日志文件中
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            e.printStackTrace(new java.io.PrintWriter(buf, true));
            String expMessage = buf.toString();
            try {
                buf.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }

            // 控制台打印日志
            logger.error("[MyHandlerExceptionResoler]捕获异常：" + e.getMessage() + ",异常信息：" + expMessage);

            mv.setViewName("common/error");
            mv.addObject("result", result);

            return mv;
        }
        return null;
    }
}
