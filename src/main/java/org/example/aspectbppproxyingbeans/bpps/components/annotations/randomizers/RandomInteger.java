package org.example.aspectbppproxyingbeans.bpps.components.annotations.randomizers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomInteger {
    int min() default 0;

    int max() default 100;
}
