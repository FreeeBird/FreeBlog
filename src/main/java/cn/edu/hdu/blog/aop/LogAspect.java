package cn.edu.hdu.blog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * cn.edu.hdu.blog.controller..*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("ClientIP：{} do {}::{} ",request.getRemoteAddr(),joinPoint.getSignature().getDeclaringTypeName(),method);
    }

//    @After("pointCut()")
//    public void after(JoinPoint joinPoint) {
//        String method = joinPoint.getSignature().getName();
//        System.out.println("MyAspect after Method：{}::{}"+joinPoint.getSignature().getDeclaringTypeName()+"---"+method);
//    }

//    @AfterReturning("pointCut()")
//    public void afterReturning(JoinPoint joinPoint) {
//        String method = joinPoint.getSignature().getName();
//
//        System.out.println("MyAspect after ruturning Method：{}::{}"+joinPoint.getSignature().getDeclaringTypeName()+"---"+method);
//    }

//    @AfterThrowing("pointCut()")
//    public void afterThrowing(JoinPoint joinPoint) {
//        System.out.println("MyAspect after throwing ...");
//    }

//    @Around("pointCut()")
//    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("MyAspect around before ...");
//        joinPoint.proceed();
//        System.out.println("MyAspect around after ...");
//    }


}
