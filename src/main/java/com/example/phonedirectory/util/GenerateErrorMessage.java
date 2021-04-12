package com.example.phonedirectory.util;

import com.example.phonedirectory.dto.ErrorMessageDto;
import lombok.val;

import java.util.Date;

public class GenerateErrorMessage {

    public static String MESSAGE_CONTAINS_INCORRECT_BODY = "Incorrect body";

    public static ErrorMessageDto generateErrorMessage(String message) {
        val errorMessage = new ErrorMessageDto();
        errorMessage.setDate(new Date());
        errorMessage.setMessage(message);

        return errorMessage;

    }
}
