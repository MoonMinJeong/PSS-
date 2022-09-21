package com.example.pss.domain.notice.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateRequest {
    private String title;
    private String content;
    private String imageUrl;
    private String introduction;
}
