package com.example.phonedirectory.service;

import com.example.phonedirectory.dto.PhoneDtoCreate;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface PhoneService {

    ResponseEntity<?> createPhone(PhoneDtoCreate phoneDtoCreate);

    void deletePhoneById(UUID id);
}
