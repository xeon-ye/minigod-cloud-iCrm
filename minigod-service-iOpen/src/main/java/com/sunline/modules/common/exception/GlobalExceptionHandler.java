package com.sunline.modules.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @description: 全局异常捕获器
 * @author: Larry Lai
 * @date: 2018/6/6 10:05
 * @version: v1.0
 */
//@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//    @ExceptionHandler(value = Exception.class)
    public void handleGlobalException(HttpServletRequest req, Exception ex) {

        // 打印堆栈日志到日志文件中
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ex.printStackTrace(new java.io.PrintWriter(buf, true));
        String expMessage = buf.toString();
        try {
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 记录到日志
        log.error("[GlobalExceptionHandler]捕获异常：" + ex.getMessage() + ",异常信息：" + expMessage);
    }
}
