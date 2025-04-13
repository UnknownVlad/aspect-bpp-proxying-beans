package org.example.aspectbppproxyingbeans.aspects.testcomponents.method;


import lombok.extern.slf4j.Slf4j;
import org.example.aspectbppproxyingbeans.aspects.annotations.method.AspectBeforeExecutionMethod;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BeforeExecutionMethodTestClass {

    @AspectBeforeExecutionMethod
    public void testMethod(String arg1, String[] arg2, Integer arg3) {
        log.info("BeforeExecutionMethodTestClass#testMethod");
    }
}
