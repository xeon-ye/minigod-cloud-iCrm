package com.sunline.modules.common.aspect;//package com.sunline.modules.common.aspect;
//
//import com.alibaba.fastjson.JSONObject;
//import com.sunline.modules.common.annotation.SysLog;
//import com.sunline.modules.common.utils.IPUtils;
//import com.sunline.modules.common.utils.ShiroUtils;
//import com.sunline.modules.sys.entity.SysLogEntity;
//import com.sunline.modules.sys.entity.UserEntity;
//import com.sunline.modules.sys.service.SysLogService;
//import com.sunline.modules.sys.service.UserService;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.lang.reflect.Method;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @description: 系统日志，切面处理类
// * @author: Larry Lai
// * @date: 2018/8/27 17:37
// * @version: v1.0
// */
//
//
//@Aspect
//@Component
//public class WebSysLogAspect {
//    @Autowired
//    private SysLogService sysLogService;
//    @Autowired
//    private UserService userService;
//
//    @Pointcut("execution(public * com.sunline.modules.*.controller.*.*(..))")
//    public void logPointCut() {
//
//    }
//
//    @Before("logPointCut()")
//    public void saveSysLog(JoinPoint joinPoint) {
//        try {
//
//            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//            Method method = signature.getMethod();
//            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//            SysLogEntity sysLog = new SysLogEntity();
//            UserEntity userEntity = new UserEntity();
//
//            // 请求的方法名
//            String className = joinPoint.getTarget().getClass().getName();
//            String methodName = signature.getName();
//            sysLog.setMethod(className + "." + methodName + "()");
//            SysLog syslog = method.getAnnotation(SysLog.class);
//            if (syslog != null) {
//                // 注解上的描述
//                sysLog.setOperation(syslog.value());
//            }
//            // 设置IP地址
//            sysLog.setIp(IPUtils.getIpAddr(request));
//
//            // 请求的参数
//            Object[] args = joinPoint.getArgs();
//
//            if (args.length > 0 && !(args[0] instanceof HttpServletRequest
//                    || args[0] instanceof HttpServletResponse)) {
//                String params = getBodyMsg(args);
//                sysLog.setParams(params);
//                System.out.println(sysLog.getParams());
//                userEntity = userService.queryByLoginName(String.valueOf(args[0]));
//            }
//
//            // 用户名
//            String username = ShiroUtils.getUserEntity() == null ? userEntity == null ? null : userEntity.getUserName() : ShiroUtils.getUserEntity().getUserName();
//
//            sysLog.setUsername(username);
//
//            sysLog.setCreateDate(new Date());
//            // 保存系统日志
//            sysLogService.save(sysLog);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private static String getBodyMsg(Object[] args) {
//        if (args.length == 0) {
//            return "";
//        }
//        Map<String, Object> params = new HashMap<String, Object>();
//        for (Object arg : args) {
//            if (arg instanceof ServletRequest || arg instanceof ServletResponse || arg instanceof MultipartFile) {
//                //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
//                //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
//                continue;
//            }
//            if (arg instanceof BindingResult) {
//                continue;
//            }
//            if (arg instanceof HttpSession) {
//                continue;
//            }
//            try {
//                if("BindingAwareModelMap".equals(arg.getClass().getSimpleName())){
//                    continue;
//                }else {
//                    params.put(arg.getClass().getSimpleName(), arg);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return JSONObject.toJSONString(params) ;
//    }
//}
