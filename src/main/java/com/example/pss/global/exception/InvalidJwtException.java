package com.example.pss.global.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class InvalidJwtException extends PssException {
    public static final InvalidJwtException EXCEPTION =
            new InvalidJwtException();

    public InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
