package org.example.aspectbppproxyingbeans.aspects.testcomponents.param;

import org.example.aspectbppproxyingbeans.AspectBppProxyingBeansApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("custom-test")
class BeforeExecutionParamTestClassTest extends AspectBppProxyingBeansApplicationTests {

    @Autowired
    private BeforeExecutionParamTestClass testClass;

    @Test
    void testMethod() {
        testClass.testMethod(
                "Test str arg1",
                new String[]{"arg2_1", "arg2_2", "arg2_3"},
                92145
        );
    }
}