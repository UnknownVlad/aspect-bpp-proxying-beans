package org.example.aspectbppproxyingbeans.aspects.processors.method;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.aspectbppproxyingbeans.aspects.annotations.method.AspectAroundExecutionMethod;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class AroundExecutionMethodAspectProcessor {

    @Around("@annotation(aspectAroundExecutionMethod)")
    public Object aroundExecution(ProceedingJoinPoint joinPoint, AspectAroundExecutionMethod aspectAroundExecutionMethod) {
        log.info("CALL METHOD AROUND EXECUTION: [AspectAroundExecutionMethod]");
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("METHOD NAME: [{}]", methodName);
        Arrays.stream(args).forEach(arg -> log.info("ARG: [{}]", arg));

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

        log.info("SUCCESS PROCESSING, RESULT: [{}]", result);
        log.info("ADDITIONAL LOGIC AROUND EXECUTION: [AspectAroundExecutionMethod]");
        log.info("END CALL METHOD AFTER RETURNING EXECUTION: [AspectAroundExecutionMethod]");
        return result;
    }


}
