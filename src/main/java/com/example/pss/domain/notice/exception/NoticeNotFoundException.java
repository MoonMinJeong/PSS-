package com.example.pss.domain.notice.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class NoticeNotFoundException extends PssException {
    public static final NoticeNotFoundException EXCEPTION =
            new NoticeNotFoundException();

    public NoticeNotFoundException() {
        super(ErrorCode.NOTICE_NOT_FOUND);
    }
}
