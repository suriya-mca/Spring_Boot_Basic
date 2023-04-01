package com.example.dummy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dummy.repository.DummyRepository;

@Service
public class DummyService {

    @Autowired
    private DummyRepository dummyRepository;

    public String dummyService() {
        return dummyRepository.dummyRepo();
    }
    
}
