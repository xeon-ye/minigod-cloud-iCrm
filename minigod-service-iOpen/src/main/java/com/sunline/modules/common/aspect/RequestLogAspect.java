package com.sunline.modules.common.aspect;

import com.alibaba.fastjson.JSONObject;
import com.sunline.modules.common.annotation.SystemLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 请求日志切面类
 * @author: Larry Lai
 * @date: 2019/6/12 11:17
 * @version: v1.0
 */

@Component
@Aspect
public class RequestLogAspect {

    public static final Logger logger = LoggerFactory.getLogger(RequestLogAspect.class);

    /**
     * Define a pointcut
     */
    @Pointcut("@annotation(com.sunline.modules.common.annotation.SystemLog)")
    public void controllerLog() {}

    /**
     * Print Log before controller
     * @param joinPoint
     */
    @Before("controllerLog()")
    public void before(JoinPoint joinPoint) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        logger.info("方法描述：{}", getMethodDescription(joinPoint));
        logger.info("请求IP：{}", request.getRemoteAddr());
        logger.info("请求路径：{}", request.getRequestURL());
        logger.info("请求方式：{}", request.getMethod());
        logger.info("请求参数：{}", getBodyMsg(joinPoint.getArgs()));

    }

    private static String getBodyMsg(Object[] args) {
        if (args.length == 0) {
            return "";
        }
        Map<String,Object> params = new HashMap<String,Object>();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                continue;
            }
            if (arg instanceof HttpSession) {
                continue;
            }
            // 如果参数中含有文件，不打印文件相关信息
            if (arg instanceof MultipartFile) {
                continue;
            }
            try {
                params.put(arg.getClass().getSimpleName() , arg);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSONObject.toJSONString(params);
    }

    /**
     * Print the time that request method execution spend
     * @param joinPoint
     * @throws Throwable
     */
    @Around("controllerLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        Object retVal = joinPoint.proceed(args);
        long endTime = System.currentTimeMillis();
        logger.info("执行时间：{} ms", endTime - startTime);
        logger.info("返回值：{}\n\t", JSONObject.toJSONString(retVal));
        return retVal;
    }

    /**
     * Print exception
     * @param ex
     */
    @AfterThrowing(throwing = "ex", pointcut = "controllerLog()")
    public void afterThrowing(Throwable ex) {
        logger.error("发生异常：{}", ex.toString());
    }

    /**
     * Acquire the description for annotation target method
     * @param joinPoint
     * @return
     * @throws Exception
     */
    protected String getMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();

        String description = "";
        for (Method method : methods) {
            if(method.getName().equals(methodName)) {
                Class<?>[] clazzs = method.getParameterTypes();
                if(clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
}
