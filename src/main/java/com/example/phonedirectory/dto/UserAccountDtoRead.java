package com.example.phonedirectory.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserAccountDtoRead {

    private UUID id;
    private String username;
    private List<PhoneDtoRead> phones;
}
