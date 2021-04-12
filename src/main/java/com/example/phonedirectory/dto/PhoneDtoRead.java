package com.example.phonedirectory.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PhoneDtoRead {

    private UUID id;
    private String number;
}
