package com.example.pss.global.exception;

import com.example.pss.global.error.exception.ErrorCode;
import com.example.pss.global.error.exception.PssException;

public class ImageNotValueException extends PssException {
    public static final ImageNotValueException EXCEPTION =
            new ImageNotValueException();

    public ImageNotValueException() {
        super(ErrorCode.IMAGE_VALUE_NOT_FOUND);
    }
}
