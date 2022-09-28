package com.example.pss.domain.notice.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class NoticeResponse {
    private String title;
    private String imageUrl;
    private String introduction;
    private int viewCount;
    private float stars;
}
