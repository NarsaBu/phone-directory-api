package com.example.phonedirectory.controller;

import com.example.phonedirectory.dto.PhoneDtoCreate;
import com.example.phonedirectory.service.PhoneService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping(produces= MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createPhone(@RequestBody PhoneDtoCreate phoneDtoCreate) {
        return phoneService.createPhone(phoneDtoCreate);
    }

    @DeleteMapping(value = "/{id}", produces= MediaType.APPLICATION_XML_VALUE)
    public void deletePhoneById(@PathVariable(name = "id") UUID id) {
        phoneService.deletePhoneById(id);
    }
}
