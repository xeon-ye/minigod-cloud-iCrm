package com.sunline.modules.common.aspect;

import com.alibaba.fastjson.JSON;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.utils.HttpContextUtils;
import com.sunline.modules.common.utils.IPUtils;
import com.sunline.modules.common.utils.ShiroUtils;
import com.sunline.modules.sys.entity.SysLogEntity;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.sys.service.SysLogService;
import com.sunline.modules.sys.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @description: 系统日志，切面处理类
 * @author: Larry Lai
 * @date: 2018/8/27 17:37
 * @version: v1.0
 */


@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private UserService userService;

    @Pointcut("@annotation(com.sunline.modules.common.annotation.SysLog)")
    public void logPointCut() {

    }

    @Before("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLogEntity sysLog = new SysLogEntity();
        UserEntity userEntity=new UserEntity();

        SysLog syslog = method.getAnnotation(SysLog.class);
        if (syslog != null) {
            // 注解上的描述
            sysLog.setOperation(syslog.value());
        }

        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");

        // 请求的参数
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            String params = JSON.toJSONString(args[0]);
            sysLog.setParams(params);
            userEntity = userService.queryByLoginName(String.valueOf(args[0]));
        }

        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));

        // 用户名
        String username = ShiroUtils.getUserEntity() == null ? userEntity == null ? String.valueOf(args[0]) : userEntity.getUserName() : ShiroUtils.getUserEntity().getUserName();

        sysLog.setUsername(username);

        sysLog.setCreateDate(new Date());
        // 保存系统日志
        sysLogService.save(sysLog);
    }

}
