package com.example.phonedirectory.controller;

import com.example.phonedirectory.dto.UserAccountDtoCreate;
import com.example.phonedirectory.dto.UserAccountDtoRead;
import com.example.phonedirectory.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user-account")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping
    public List<UserAccountDtoRead> getUserAccountList() {
        return userAccountService.getUserAccountList();
    }

    @PostMapping
    public ResponseEntity<?> createUserAccount(@RequestBody UserAccountDtoCreate userAccountDtoCreate) {
        return userAccountService.createUserAccount(userAccountDtoCreate);
    }

    @DeleteMapping("/{id}")
    public void deleteUserAccountById(@PathVariable(name = "id") UUID id) {
        userAccountService.deleteUserAccountById(id);
    }
}
