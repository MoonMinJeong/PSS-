package com.example.pss.domain.user.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class UserExistException extends PssException {
    public static final UserExistException EXCEPTION =
            new UserExistException();

    public UserExistException() {
        super(ErrorCode.USER_EXISTS);
    }
}
