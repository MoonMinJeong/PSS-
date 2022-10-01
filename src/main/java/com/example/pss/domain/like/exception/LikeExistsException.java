package com.example.pss.domain.like.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class LikeExistsException extends PssException {
    public static final LikeExistsException EXCEPTION =
            new LikeExistsException();

    public LikeExistsException() {
        super(ErrorCode.LIKE_EXISTS);
    }
}
