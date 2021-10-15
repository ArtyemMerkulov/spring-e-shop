package com.geekbrains.backend.aspect;

import com.geekbrains.backend.exception.ApplicationException;
import com.geekbrains.frontend.exception.AppException;
import com.vaadin.flow.component.UI;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Aspect
@Service
@Order(1)
public class ExceptionWrapper {

    @Around(value = "execution(* com.geekbrains.backend.*.*.*.*(..))")
    public Object sendErrorBack(ProceedingJoinPoint pjp) {
        Object value = null;
        try {
            value = pjp.proceed();
        } catch (Throwable e) {
            UI.getCurrent().navigate(AppException.class, new ApplicationException(e.getMessage()).toString());
        }
        return value;
    }

    @Around(value = "execution(* com.geekbrains.frontend.*.*.*(..))")
    public Object sendErrorFront(ProceedingJoinPoint pjp) {
        Object value = null;
        try {
            value = pjp.proceed();
        } catch (Throwable e) {
            UI.getCurrent().navigate(AppException.class, new ApplicationException(e.getMessage()).toString());
        }
        return value;
    }

}
