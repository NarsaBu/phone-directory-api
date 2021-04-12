package com.example.phonedirectory.mapper;

import com.example.phonedirectory.dto.UserAccountDtoRead;
import com.example.phonedirectory.model.UserAccount;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAccountMapper {

    public UserAccountDtoRead userAccountToUserAccountDtoRead(UserAccount userAccount) {
        val mapper = new ModelMapper();
        return mapper.map(userAccount, UserAccountDtoRead.class);
    }

    public List<UserAccountDtoRead> userAccountToUserAccountDtoRead(List<UserAccount> list) {
        return list.stream().map(this::userAccountToUserAccountDtoRead).collect(Collectors.toList());
    }

}
