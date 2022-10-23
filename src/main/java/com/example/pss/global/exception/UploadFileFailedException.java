package com.example.pss.global.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class UploadFileFailedException extends PssException {
    public static final UploadFileFailedException EXCEPTION =
            new UploadFileFailedException();

    public UploadFileFailedException() {
        super(ErrorCode.UPLOAD_FILE_FAILED);
    }
}
