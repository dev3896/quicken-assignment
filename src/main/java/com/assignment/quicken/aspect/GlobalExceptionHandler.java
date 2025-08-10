package com.assignment.quicken.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Aspect
public class GlobalExceptionHandler {

    @Pointcut(value = "com.assignment.quicken..*(..)")
    private void applicationPointcut() {}

    @Around("applicationPointcut()")
    public void handleException(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
        } catch (ResponseStatusException ex) {
            throw ex;
        } catch (Throwable e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}