package com.example.pss.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PssException extends RuntimeException{
    private final ErrorCode errorCode;
}
