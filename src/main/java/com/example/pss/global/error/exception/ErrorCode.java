package com.example.pss.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    UPLOAD_FILE_FAILED(400, "AUTH-400-1", "Upload File Failed"),
    SAVE_IMAGE_FAILED(400, "COMMON-400-1", "Save Image Failed"),

    INVALID_JWT(401, "JWT-401-1", "Invalid Jwt"),
    EXPIRED_JWT(401, "jwt-401-2", "Expired Jwt"),

    NOT_MINE(403, "grant-403-1", "Not Mine"),

    NOTICE_NOT_FOUND(404, "notice-404-1", "notice not found"),
    STACK_NOT_FOUND(404, "stack-404-1", "stack not found"),
    STAR_NOT_FOUND(404, "star-404-1", "star not found"),
    COMMENT_NOT_FOUND(404, "comment-404-1", "comment not found"),
    REPLY_NOT_FOUND(404, "reply-404-1", "reply not found"),
    IMAGE_VALUE_NOT_FOUND(404, "COMMON-404-1", "Image Value Not Found"),

    USER_EXISTS(409, "USER-409-1", "User Exists"),
    LIKE_EXISTS(409, "LIKE-409-1", "Like Exists"),
    STACK_EXISTS(409, "STACK-409-1", "Stack Exists"),
    MEMBER_EXISTES(409, "MEMBER-409-1", "Member Exists"),
    STAR_EXISTS(409, "STAR-409-1", "Star Exists"),

    USER_NOTFOUND_EXCEPTION(404, "user-404-1", "user not found");

    private final int status;
    private final String code;
    private final String message;
    
}
