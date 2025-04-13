package org.example.aspectbppproxyingbeans.aspects.processors.method;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.aspectbppproxyingbeans.aspects.annotations.method.AspectBeforeExecutionMethod;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class BeforeExecutionMethodAspectProcessor {

    @Before("@annotation(aspectBeforeExecutionMethod)")
    public void beforeMethodExecution(JoinPoint joinPoint, AspectBeforeExecutionMethod aspectBeforeExecutionMethod) {
        log.info("CALL METHOD BEFORE EXECUTION: [AspectBeforeExecutionMethod]");
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("METHOD NAME: [{}]", methodName);
        Arrays.stream(args).forEach(arg -> log.info("ARG: [{}]", arg));
        log.info("END CALL METHOD BEFORE EXECUTION: [AspectBeforeExecutionMethod]");
    }
}
