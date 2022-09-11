package com.example.pss.global.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PssException extends RuntimeException{
    private final ErrorCode errorCode;
}
