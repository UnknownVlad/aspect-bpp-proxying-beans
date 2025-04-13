package org.example.aspectbppproxyingbeans.aspects.testcomponents.param;


import lombok.extern.slf4j.Slf4j;
import org.example.aspectbppproxyingbeans.aspects.annotations.method.AspectBeforeExecutionMethod;
import org.example.aspectbppproxyingbeans.aspects.annotations.param.AspectBeforeExecutionParam;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BeforeExecutionParamTestClass {

    public void testMethod(
            @AspectBeforeExecutionParam String arg1,
            String[] arg2,
            Integer arg3
    ) {
        log.info("BeforeExecutionParamTestClass#testMethod");
    }
}
