package com.example.phonedirectory.mapper;

import com.example.phonedirectory.dto.PhoneDtoRead;
import com.example.phonedirectory.model.Phone;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {

    public PhoneDtoRead phoneToPhoneDtoRead(Phone phone) {
        val mapper = new ModelMapper();
        return mapper.map(phone, PhoneDtoRead.class);
    }
}
