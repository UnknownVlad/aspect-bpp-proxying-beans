package org.example.aspectbppproxyingbeans.aspects.annotations.method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для аспекта, которая работает ВО ВРЕМЯ выполнения метода
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AspectAroundExecutionMethod {
}
