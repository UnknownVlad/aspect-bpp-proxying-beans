package org.example.aspectbppproxyingbeans.bpps.components.support;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SupportBeans {
    @Bean
    public List<String> genders() {
        return List.of("Male", "Female");
    }
}
