package com.example.pss.domain.reply.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class ReplyNotFoundException extends PssException {
    public static final ReplyNotFoundException EXCEPTION =
            new ReplyNotFoundException();

    public ReplyNotFoundException() {
        super(ErrorCode.REPLY_NOT_FOUND);
    }
}
