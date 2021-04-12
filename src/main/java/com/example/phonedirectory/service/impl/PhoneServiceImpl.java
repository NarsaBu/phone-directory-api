package com.example.phonedirectory.service.impl;

import com.example.phonedirectory.dto.PhoneDtoCreate;
import com.example.phonedirectory.mapper.PhoneMapper;
import com.example.phonedirectory.model.Phone;
import com.example.phonedirectory.repository.PhoneRepository;
import com.example.phonedirectory.repository.UserAccountRepository;
import com.example.phonedirectory.service.PhoneService;
import com.example.phonedirectory.util.GenerateErrorMessage;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    private final UserAccountRepository userAccountRepository;

    private final PhoneMapper phoneMapper;

    public PhoneServiceImpl(PhoneRepository phoneRepository,
                            UserAccountRepository userAccountRepository,
                            PhoneMapper phoneMapper
    ) {
        this.phoneRepository = phoneRepository;
        this.userAccountRepository = userAccountRepository;
        this.phoneMapper = phoneMapper;
    }

    @Override
    public ResponseEntity<?> createPhone(PhoneDtoCreate phoneDtoCreate) {
        try {
            var phone = new Phone();

            if (phoneDtoCreate.getNumber().equals("")) {
                throw new RuntimeException(GenerateErrorMessage.MESSAGE_CONTAINS_INCORRECT_BODY);
            }

            val userAccount = userAccountRepository.findById(phoneDtoCreate.getUserAccountId()).orElse(null);
            if (userAccount == null) {
                throw new RuntimeException(GenerateErrorMessage.MESSAGE_CONTAINS_INCORRECT_BODY);
            } else {
                phone.setNumber(phoneDtoCreate.getNumber());
                phone = phoneRepository.save(phone);

                val list = userAccount.getPhones();
                list.add(phone);
                userAccount.setPhones(list);
                userAccountRepository.save(userAccount);
            }

            return new ResponseEntity<>(phoneMapper.phoneToPhoneDtoRead(phone), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(GenerateErrorMessage.MESSAGE_CONTAINS_INCORRECT_BODY);
        }
    }

    @Override
    public void deletePhoneById(UUID id) {
        phoneRepository.deleteById(id);
    }
}
