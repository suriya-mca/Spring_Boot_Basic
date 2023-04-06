package com.example.dummy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dummy.schema.Dummy;
import com.example.dummy.repository.DummyRepository;
import com.example.dummy.helper.exception.NotFoundException;
import java.util.List;
import java.util.Optional;

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

    public Optional<Dummy> getOneService(int id) {
        Optional<Dummy> data = dummyRepository.getOneDummy(id);
        if(data.isEmpty())
            throw new NotFoundException("data not found");  
        return data;
    }

    public void deleteService(int id) {
        Optional<Dummy> data = dummyRepository.getOneDummy(id);
        if(data.isEmpty())
            throw new NotFoundException("data not found");
        else  
            dummyRepository.deleteDummy(id);
    }
    
}
