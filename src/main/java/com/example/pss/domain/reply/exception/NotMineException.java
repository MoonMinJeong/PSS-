package com.example.pss.domain.reply.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class NotMineException extends PssException {
    public static final NotMineException EXCEPTION =
            new NotMineException();

    public NotMineException() {
        super(ErrorCode.NOT_MINE);
    }
}
