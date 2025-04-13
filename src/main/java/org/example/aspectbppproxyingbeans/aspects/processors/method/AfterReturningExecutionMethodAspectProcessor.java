package org.example.aspectbppproxyingbeans.aspects.processors.method;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.example.aspectbppproxyingbeans.aspects.annotations.method.AspectAfterReturningExecutionMethod;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class AfterReturningExecutionMethodAspectProcessor {

    @AfterReturning(pointcut = "@annotation(aspectAfterReturningExecutionMethod)", returning = "result")
    public void afterReturningExecution(JoinPoint joinPoint, Object result, AspectAfterReturningExecutionMethod aspectAfterReturningExecutionMethod) {
        log.info("CALL METHOD AFTER RETURNING EXECUTION: [AspectAfterReturningExecutionMethod]");
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("METHOD NAME: [{}]", methodName);
        Arrays.stream(args).forEach(arg -> log.info("ARG: [{}]", arg));

        log.info("METHOD RETURNING RESULT: [{}]", result);
        log.info("END CALL METHOD AFTER RETURNING EXECUTION: [AspectAfterReturningExecutionMethod]");
    }


}
