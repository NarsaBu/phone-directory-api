package com.example.phonedirectory.service;

import com.example.phonedirectory.dto.UserAccountDtoCreate;
import com.example.phonedirectory.dto.UserAccountDtoRead;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserAccountService {

    List<UserAccountDtoRead> getUserAccountList();

    ResponseEntity<?> createUserAccount(UserAccountDtoCreate userAccountDtoCreate);

    void deleteUserAccountById(UUID id);
}
