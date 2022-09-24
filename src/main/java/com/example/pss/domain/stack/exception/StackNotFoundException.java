package com.example.pss.domain.stack.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class StackNotFoundException extends PssException {
    public static final StackNotFoundException EXCEPTION =
            new StackNotFoundException();

    public StackNotFoundException() {
        super(ErrorCode.USER_NOTFOUND_EXCEPTION);
    }
}
