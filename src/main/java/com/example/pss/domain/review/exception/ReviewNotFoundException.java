package com.example.pss.domain.review.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class ReviewNotFoundException extends PssException {
    public static final ReviewNotFoundException EXCEPTION =
            new ReviewNotFoundException();

    public ReviewNotFoundException() {
        super(ErrorCode.REVIEW_NOT_FOUND);
    }
}