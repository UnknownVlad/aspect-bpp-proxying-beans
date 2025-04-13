package org.example.aspectbppproxyingbeans.aspects.processors.method;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.example.aspectbppproxyingbeans.aspects.annotations.method.AspectAfterThrowingExecutionMethod;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class AfterThrowingExecutionMethodAspectProcessor {

    @AfterThrowing(pointcut = "@annotation(aspectAfterThrowingExecutionMethod)", throwing = "exception")
    public void afterThrowingExecution(JoinPoint joinPoint, AspectAfterThrowingExecutionMethod aspectAfterThrowingExecutionMethod, Throwable exception) {
        log.info("CALL METHOD AFTER THROWING EXECUTION: [AspectAfterThrowingExecutionMethod]");
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("METHOD NAME: [{}]", methodName);
        Arrays.stream(args).forEach(arg -> log.info("ARG: [{}]", arg));

        log.error("METHOD THROW: [{}]", exception.getMessage());
        log.info("END CALL METHOD AFTER THROWING EXECUTION: [AspectAfterThrowingExecutionMethod]");
    }


}
