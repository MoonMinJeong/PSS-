package com.example.pss.domain.comment.present.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class CommentRequest {
    private String content;
}
