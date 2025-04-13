package org.example.aspectbppproxyingbeans.aspects.annotations.method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для аспекта, которая работает ПОСЛЕ выполнения метода, независимо от успеха или ошибки, для доп логики
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AspectAfterExecutionMethod {
}
