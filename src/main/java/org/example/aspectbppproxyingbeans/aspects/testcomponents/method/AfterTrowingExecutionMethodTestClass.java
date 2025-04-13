package org.example.aspectbppproxyingbeans.aspects.testcomponents.method;


import lombok.extern.slf4j.Slf4j;
import org.example.aspectbppproxyingbeans.aspects.annotations.method.AspectAfterThrowingExecutionMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AfterTrowingExecutionMethodTestClass {

    @AspectAfterThrowingExecutionMethod
    public List<Object> testMethod(String arg1, String[] arg2, Integer arg3) {
        log.info("AfterTrowingExecutionMethodTestClass#testMethod");
        throw new RuntimeException("TEST EXCEPTION");
    }
}
