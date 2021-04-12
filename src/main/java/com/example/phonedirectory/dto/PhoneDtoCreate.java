package com.example.phonedirectory.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PhoneDtoCreate {

    private UUID userAccountId;

    private String number;
}
