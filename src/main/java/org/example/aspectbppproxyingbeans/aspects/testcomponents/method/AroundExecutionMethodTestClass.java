package org.example.aspectbppproxyingbeans.aspects.testcomponents.method;


import lombok.extern.slf4j.Slf4j;
import org.example.aspectbppproxyingbeans.aspects.annotations.method.AspectAroundExecutionMethod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AroundExecutionMethodTestClass {

    @AspectAroundExecutionMethod
    public List<Object> testMethod(String arg1, String[] arg2, Integer arg3) {
        log.info("AfterExecutionMethodTestClass#testMethod");
        List<Object> list = new ArrayList<>();
        list.add(arg1);
        list.addAll(List.of(arg2));
        list.add(arg3);
        return list;
    }
}
