package org.example.aspectbppproxyingbeans.bpps.components.impl;


import org.example.aspectbppproxyingbeans.bpps.components.interfaces.RandomGenerator;

import java.util.UUID;

public class RandomStringGenerator implements RandomGenerator<String> {
    @Override
    public String generateValue() {
        return UUID.randomUUID().toString();
    }
}
