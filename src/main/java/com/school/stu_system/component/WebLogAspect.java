package com.school.stu_system.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @program: stu_system
 * @description: 服务请求日志输出
 * @author: William Munch
 * @create: 2021-04-20 14:02
 **/
@Aspect
@Component
public class WebLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    private final static ObjectMapper mapper = new ObjectMapper();

    /**
     * 以 controller 包下定义的所有请求为切入点
     */
    @Pointcut("execution(public * com.school.stu_system.controller.*.*(..))")
    public void webLog() {
    }

    /**
     * 前置通知：在目标方法执行前调用
     *
     * @param joinPoint
     * @throws Throwable 异常
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 打印请求相关参数
        logger.info("========================================== Start ==========================================");
        // 打印请求 url
        logger.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        logger.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        Object[] args = Arrays.stream(joinPoint.getArgs()).filter(o -> !(o instanceof BindingResult || o instanceof HttpServletResponse || o instanceof HttpServletRequest)).toArray();
        logger.info("Request Args   : {}", mapper.writeValueAsString(args));
    }

    /**
     * 后置/最终通知：无论目标方法在执行过程中出现异常 都会在它之后调用
     *
     * @throws Throwable 异常
     */
//    @After("webLog()")
//    public void doAfter() throws Throwable {
//        logger.info("=========================================== End ===========================================");
//        // 每个请求之间空一行
//        logger.info("");
//    }
    /**
     * 后置通知：在目标方法执行后调用，若目标方法出现异常，则不执行
     */
    @AfterReturning("webLog()")
    public void doAfterReturn() {
        logger.info("========================================= Success End =====================================");
        logger.info("");
    }

    /**
     * 异常通知：目标方法抛出异常时执行
     */
    @AfterThrowing("webLog()")
    public void doAfterThrow() {
        logger.info("========================================== Error End ======================================");
        logger.info("");
    }

    /**
     * 环绕
     *
     * @param proceedingJoinPoint 切点
     * @return 返回结果
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        logger.info("Response Args  : {}", mapper.writeValueAsString(result));
        // 执行耗时
        logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }
}

