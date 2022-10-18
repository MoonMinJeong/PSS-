package com.example.pss.domain.comment.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class CommentNotFoundException extends PssException {
    public static final CommentNotFoundException EXCEPTION =
            new CommentNotFoundException();

    public CommentNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }
}
