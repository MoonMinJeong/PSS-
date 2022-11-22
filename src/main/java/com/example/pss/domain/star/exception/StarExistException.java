package com.example.pss.domain.star.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class StarExistException extends PssException {
    public static final StarExistException EXCEPTION =
            new StarExistException();

    public StarExistException() {
        super(ErrorCode.STAR_EXISTS);
    }
}
