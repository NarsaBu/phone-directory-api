package com.example.phonedirectory.service.impl;

import com.example.phonedirectory.dto.UserAccountDtoCreate;
import com.example.phonedirectory.dto.UserAccountDtoRead;
import com.example.phonedirectory.mapper.UserAccountMapper;
import com.example.phonedirectory.model.UserAccount;
import com.example.phonedirectory.repository.UserAccountRepository;
import com.example.phonedirectory.service.UserAccountService;
import com.example.phonedirectory.util.GenerateErrorMessage;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    private final UserAccountMapper userAccountMapper;

    public UserAccountServiceImpl(UserAccountRepository repository, UserAccountMapper userAccountMapper) {
        this.repository = repository;
        this.userAccountMapper = userAccountMapper;
    }

    @Override
    public List<UserAccountDtoRead> getUserAccountList() {
        return userAccountMapper.userAccountToUserAccountDtoRead(repository.findAll());
    }

    @Override
    public ResponseEntity<?> createUserAccount(UserAccountDtoCreate userAccountDtoCreate) {
        try {
            if (userAccountDtoCreate.getUsername().equals("")) {
                throw new RuntimeException(GenerateErrorMessage.MESSAGE_CONTAINS_INCORRECT_BODY);
            }

            val userAccount = new UserAccount();
            userAccount.setUsername(userAccountDtoCreate.getUsername());

            return new ResponseEntity<>(userAccountMapper.userAccountToUserAccountDtoRead(repository.save(userAccount)), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(GenerateErrorMessage.MESSAGE_CONTAINS_INCORRECT_BODY);
        }
    }

    @Override
    public void deleteUserAccountById(UUID id) {
        repository.deleteById(id);
    }
}
