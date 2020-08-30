package ru.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
import java.util.stream.Stream;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* ru.controller.*.*(..))")
    public void controllerPointcut() {}

    @Pointcut("execution(* ru.sevice.*.*(..))")
    public void servicePointcut() {}

    @Pointcut("execution(* ru.dao.*.*(..))")
    public void repoPointcur() {}

    @Pointcut("controllerPointcut() || servicePointcut() || repoPointcur()")
    public void mvcPointcut() {}

    @Before("mvcPointcut()")
    public void loggingBefore(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature().toShortString());

        Stream.of(joinPoint.getArgs()).forEach(a -> {
            logger.info(a.toString());
        });
    }

    @AfterReturning(value = "mvcPointcut()")
    public void loggingAfter(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature().toShortString());
    }

}
