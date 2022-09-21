package com.example.pss.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    INVALID_JWT(401, "JWT-401-1", "Invalid Jwt"),
    EXPIRED_JWT(401, "jwt-401-2", "Expired Jwt"),

    USER_EXISTS(409, "USER-409-1", "User Exists"),

    USER_NOTFOUND_EXCEPTION(404, "user-404-1", "user not found");

    private final int status;
    private final String code;
    private final String message;
    
}
