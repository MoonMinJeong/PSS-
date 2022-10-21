package com.example.pss.global.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class SaveImageFailedException extends PssException {
    public static final SaveImageFailedException EXCEPTION =
            new SaveImageFailedException();

    public SaveImageFailedException() {
        super(ErrorCode.SAVE_IMAGE_FAILED);
    }
}
