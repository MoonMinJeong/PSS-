package com.example.pss.global.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class ExpiredJwtException extends PssException {
    public static final ExpiredJwtException EXCEPTION =
            new ExpiredJwtException();

    public ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}
