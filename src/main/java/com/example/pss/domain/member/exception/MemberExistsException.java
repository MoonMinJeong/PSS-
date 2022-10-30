package com.example.pss.domain.member.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class MemberExistsException extends PssException {
    public static final MemberExistsException EXCEPTION =
            new MemberExistsException();

    public MemberExistsException() {
        super(ErrorCode.MEMBER_EXISTES);
    }
}
