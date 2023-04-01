package com.example.dummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dummy.service.DummyService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path = "/api/v1", produces = "application/json")
public class DummyController {

    @Autowired
    private DummyService serviceController;

    @GetMapping
    public String dummyFunction() {
        return serviceController.dummyService();
    }
    
}
