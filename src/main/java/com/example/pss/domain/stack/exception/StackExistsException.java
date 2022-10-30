package com.example.pss.domain.stack.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class StackExistsException extends PssException {
    public static final StackExistsException EXCEPTION =
            new StackExistsException();

    public StackExistsException() {
        super(ErrorCode.STACK_EXISTS);
    }
}
