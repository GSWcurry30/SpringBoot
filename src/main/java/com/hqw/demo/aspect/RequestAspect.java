package com.hqw.demo.aspect;




import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component
@Aspect
public class RequestAspect {

    private final static Logger logger = LoggerFactory.getLogger(RequestAspect.class);

    @Pointcut("execution(public * com.hqw.demo.controller.DqController.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(servletRequestAttributes).getRequest();

        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //param
        Object[] args = joinPoint.getArgs();
        logger.info("args={}",args);
        //classinfo
        logger.info("DeclaringType={}",joinPoint.getSignature().getDeclaringType());
        logger.info("DeclaringTypeName={}",joinPoint.getSignature().getDeclaringTypeName());

        logger.info("this={}",joinPoint.getThis());
        logger.info("target={}",joinPoint.getTarget());

        logger.info("toString={}",joinPoint.toString());
        logger.info("tolongString={}",joinPoint.toLongString());
        logger.info("toShortString={}",joinPoint.toShortString());

    }

    @After("log()")
    public void doAfter(JoinPoint joinPoint){
        logger.info("after");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterreturning(Object object){
        logger.info("response={}",object.toString());
    }
}
