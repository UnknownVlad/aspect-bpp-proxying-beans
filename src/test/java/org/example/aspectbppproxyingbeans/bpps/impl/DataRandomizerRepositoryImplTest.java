package org.example.aspectbppproxyingbeans.bpps.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.example.aspectbppproxyingbeans.AspectBppProxyingBeansApplicationTests;
import org.example.aspectbppproxyingbeans.bpps.components.interfaces.DataRandomizerRepository;
import org.example.aspectbppproxyingbeans.bpps.pojos.UserPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class DataRandomizerRepositoryImplTest extends AspectBppProxyingBeansApplicationTests {

    @Autowired
    private DataRandomizerRepository<UserPojo> dataRandomizerRepository;

    @SneakyThrows
    @Test
    void generate() {
        UserPojo generated = dataRandomizerRepository.generate();
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println("GENERATED");
        System.out.println(
                objectMapper.writeValueAsString(generated)
        );
    }
}