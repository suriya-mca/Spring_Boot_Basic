package com.example.dummy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dummy.schema.Dummy;
import com.example.dummy.repository.DummyRepository;
import java.util.List;

@Service
public class DummyService {

    @Autowired
    private DummyRepository dummyRepository;

    public void addService(Dummy dummy) {
        dummyRepository.addDummy(dummy);
    }

    public List<Dummy> getAllService() {
        return dummyRepository.getAllDummy();
    }
    
}
