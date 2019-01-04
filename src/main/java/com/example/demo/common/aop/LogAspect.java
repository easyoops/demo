package com.example.demo.common.aop;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.bean.ResultBean;
import com.example.demo.common.exception.CheckException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by wuwf on 17/4/27.
 * 日志切面
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Autowired
    private JavaMailSender sender;

    //    @Pointcut("execution(public * com.example.demo.controller..*.*(..))")
    @Pointcut("execution(public com.example.demo.common.bean.ResultBean *(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("方法的返回值: " + JSON.toJSONString(ret));
    }

    //后置异常通知
    @AfterThrowing(throwing = "ex", pointcut = "webLog()")
    public void afterThrowing(Throwable ex) {
        System.out.println("方法异常时执行....." + ex.toString());
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")
    public void after(JoinPoint jp) {
        System.out.println("方法最后执行.....");
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("webLog()")
    public Object around(ProceedingJoinPoint point) {
        long startSec = System.currentTimeMillis();
        ResultBean<?> result;
        try {
            result = (ResultBean<?>) point.proceed();
            long endSec = System.currentTimeMillis();
            logger.info("耗时： " + (endSec - startSec));
        } catch (Throwable throwable) {
            result = handleException(throwable);
        }
        return result;
    }


    public ResultBean<?> handleException(Throwable e) {
        ResultBean<?> result = new ResultBean<>();

        if (e instanceof CheckException) {
            result.setMessage(e.getLocalizedMessage());
            result.setCode(ResultBean.FAILURE);
        }
        //...捕获已知异常和 未知异常，加以区分
        else {
            result.setMessage(e.toString());
            //未知异常，此处可以邮件短信服务通知
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jaywechen@qq.com");
        message.setTo("jaywechen@163.com","jaywechen@gmail.com");
        if (e != null) {
            message.setText("cause:" + e.toString() + ",stackTrace:" + e.getStackTrace()[0].toString());
        }
        sender.send(message);
        return result;
    }
}