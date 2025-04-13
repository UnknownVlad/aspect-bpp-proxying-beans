package org.example.aspectbppproxyingbeans.bpps.components.annotations.randomizers;


import org.example.aspectbppproxyingbeans.bpps.components.enums.PatternType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomStringPattern {
    PatternType patternType();
}
