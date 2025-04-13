package org.example.aspectbppproxyingbeans.aspects.annotations.method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для аспекта, которая работает ПОСЛЕ ИСКЛЮЧЕНИЯ при выполнении
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AspectAfterThrowingExecutionMethod {
}
