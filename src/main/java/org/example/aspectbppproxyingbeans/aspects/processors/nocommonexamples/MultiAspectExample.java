package org.example.aspectbppproxyingbeans.aspects.processors.nocommonexamples;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MultiAspectExample {

    @Pointcut("@annotation(org.example.aspectbppproxyingbeans.aspects.annotations.nocommonexamples.AspectNoCommonExample)")
    public void methodWithAspectNoCommonExample() {}

    @Before("methodWithAspectNoCommonExample()")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Before execution of method [{}] with @AspectNoCommonExample annotation", methodName);
    }

    @After("methodWithAspectNoCommonExample()")
    public void afterMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("After execution of method [{}] with @AspectNoCommonExample annotation", methodName);
    }

    @Around("methodWithAspectNoCommonExample()")
    public Object aroundMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        log.info("Before execution of method [{}] with @AspectNoCommonExample annotation", methodName);

        Object result = joinPoint.proceed();

        log.info("After execution of method [{}] with @AspectNoCommonExample annotation", methodName);
        return result;
    }
}
