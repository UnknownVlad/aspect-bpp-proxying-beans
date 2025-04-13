package org.example.aspectbppproxyingbeans.aspects.processors.method;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.example.aspectbppproxyingbeans.aspects.annotations.method.AspectAfterExecutionMethod;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class AfterExecutionMethodAspectProcessor {

    @After("@annotation(aspectAfterExecutionMethod)")
    public void afterExecution(JoinPoint joinPoint, AspectAfterExecutionMethod aspectAfterExecutionMethod) {
        log.info("CALL METHOD AFTER RETURNING EXECUTION: [AspectAfterExecutionMethod]");
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("METHOD NAME: [{}]", methodName);
        Arrays.stream(args).forEach(arg -> log.info("ARG: [{}]", arg));

        //todo: выполнить доп логику после метода
        log.info("ADDITIONAL LOGIC AFTER EXECUTION: [AspectAfterExecutionMethod]");
        log.info("END CALL METHOD AFTER RETURNING EXECUTION: [AspectAfterExecutionMethod]");
    }


}
