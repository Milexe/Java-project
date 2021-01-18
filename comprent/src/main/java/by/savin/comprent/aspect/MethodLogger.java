package by.savin.comprent.aspect;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


@Component
@Aspect
@Slf4j
public class MethodLogger {
    @Pointcut("@annotation(by.savin.comprent.aspect.Loggable)")
    public void webServiceMethod() { }
    FileHandler fh;
    private static Logger log = Logger.getLogger(MethodLogger.class.getName());
    @Around("webServiceMethod()")
    public Object logWebServiceCall(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();
        fh = new FileHandler("F:\\labs\\java\\log\\MyLogFile.log");
        log.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        log.info("Call method " + methodName + " with args " + methodArgs);

        Object result = thisJoinPoint.proceed();

        log.info("Method " + methodName + " returns " + result);

        return result;
    }
}
