package com.example.pss.domain.review.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class ReviewExistException extends PssException {

    public static final ReviewExistException EXCEPTION =
            new ReviewExistException();

    public ReviewExistException() {
        super(ErrorCode.REVIEW_EXISTS);
    }
}
