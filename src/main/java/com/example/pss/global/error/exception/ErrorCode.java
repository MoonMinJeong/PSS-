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

    NOTICE_NOT_FOUND(404, "notice-404-1", "notice not found"),
    STACK_NOT_FOUND(404, "stack-404-1", "stack not found"),

    USER_EXISTS(409, "USER-409-1", "User Exists"),
    LIKE_EXISTS(409, "LIKE-409-1", "Like Exists"),

    USER_NOTFOUND_EXCEPTION(404, "user-404-1", "user not found");

    private final int status;
    private final String code;
    private final String message;
    
}
