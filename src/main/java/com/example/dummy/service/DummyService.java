package com.example.dummy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.example.dummy.schema.Dummy;
import com.example.dummy.repository.DummyRepository;
import com.example.dummy.helper.exception.NotFoundException;
import com.example.dummy.helper.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@Service
public class DummyService {

    @Autowired
    private DummyRepository dummyRepository;

    public ResponseEntity<Object> addService(Dummy dummy) {
        return ResponseHandler.responseBuilder(
            "saved successfully!", 
            HttpStatus.CREATED, 
            dummyRepository.addDummy(dummy)
        );
    }

    public List<Dummy> getAllService() {
        return dummyRepository.getAllDummy();
    }

    public ResponseEntity<Object> getOneService(int id) {
        Optional<Dummy> data = dummyRepository.getOneDummy(id);
        if(data.isEmpty())
            throw new NotFoundException("data not found");  
        return ResponseHandler.responseBuilder(
            "requested details are given here", 
            HttpStatus.OK, 
            data
        );
    }

    public ResponseEntity<Object> deleteService(int id) {
        Optional<Dummy> data = dummyRepository.getOneDummy(id);
        if(data.isEmpty())
            throw new NotFoundException("data not found");
        return ResponseHandler.responseBuilder(
            "deleted successfully!", 
            HttpStatus.OK, 
            dummyRepository.deleteDummy(id)
        );
    }
    
}
