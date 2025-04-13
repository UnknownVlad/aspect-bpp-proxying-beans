package org.example.aspectbppproxyingbeans.aspects.processors.param;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aspectbppproxyingbeans.aspects.annotations.param.AspectBeforeExecutionParam;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Slf4j
@Aspect
@Component
@Profile("custom-test")
public class BeforeExecutionParamAspectProcessor {

    @Before("execution(* org.example.aspectbppproxyingbeans..*(..))")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        log.info("CALL PARAM BEFORE EXECUTION: [AspectBeforeExecutionParam]");

        String methodName = joinPoint.getSignature().getName();
        log.info("METHOD NAME: [{}]", methodName);

        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Parameter[] parameters = method.getParameters();

        for (int i = 0; i < args.length; i++) {
            log.info("ARG: [{}]", args[i]);
        }

        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if (annotation instanceof AspectBeforeExecutionParam) {
                    Object trackedValue = args[i];
                    String paramType = parameters[i].getType().getSimpleName();
                    String paramName = parameters[i].getName();
                    log.info(">> Tracked PARAM [{}] of type [{}] = [{}]", paramName, paramType, trackedValue);
                }
            }
        }

        log.info("END CALL PARAM BEFORE EXECUTION: [AspectBeforeExecutionParam]");
    }
}
