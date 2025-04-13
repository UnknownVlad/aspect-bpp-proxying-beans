package org.example.aspectbppproxyingbeans.bpps.impl;


import org.example.aspectbppproxyingbeans.bpps.components.annotations.RandomizerRepository;
import org.example.aspectbppproxyingbeans.bpps.components.interfaces.DataRandomizerRepository;
import org.example.aspectbppproxyingbeans.bpps.pojos.UserPojo;

@RandomizerRepository
public class DataRandomizerRepositoryImpl implements DataRandomizerRepository<UserPojo> {

    @Override
    public UserPojo generate() {
        return null;
    }
}
