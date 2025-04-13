package org.example.aspectbppproxyingbeans.bpps.components.annotations.processors;

import java.lang.reflect.Field;


public interface RandomizerAnnotationProcessor {

    void process(Object object, Field field);

}
