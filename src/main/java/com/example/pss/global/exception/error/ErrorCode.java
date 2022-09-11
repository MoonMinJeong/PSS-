package com.example.pss.global.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    USER_NOTFOUND_EXCEPTION(404, "user-404-1", "user not found");

    private final int status;
    private final String code;
    private final String message;
    
}
