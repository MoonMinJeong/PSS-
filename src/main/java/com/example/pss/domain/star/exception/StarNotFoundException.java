package com.example.pss.domain.star.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class StarNotFoundException extends PssException {
    public static final StarNotFoundException EXCEPTION =
            new StarNotFoundException();

    public StarNotFoundException() {
        super(ErrorCode.STAR_NOT_FOUND);
    }
}
