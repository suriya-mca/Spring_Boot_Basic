package com.example.dummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.example.dummy.schema.Dummy;
import com.example.dummy.service.DummyService;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path = "/api/v1", produces = "application/json")
public class DummyController {

    @Autowired
    private DummyService serviceController;

    @PostMapping
    public void dummyPostFunction(@RequestBody Dummy dummy) {
        serviceController.addService(dummy);
    }

    @GetMapping
    public List<Dummy> dummyGetAllFunction() {
        return serviceController.getAllService();
    }

    @GetMapping("{id}")
    public Optional<Dummy> dummyGetOneFunction(@PathVariable("id") int id) {
        return serviceController.getOneService(id);
    }

    @DeleteMapping("{id}")
    public void dummyDeleteFunction(@PathVariable("id") int id) {
        serviceController.deleteService(id);
    }
    
}
