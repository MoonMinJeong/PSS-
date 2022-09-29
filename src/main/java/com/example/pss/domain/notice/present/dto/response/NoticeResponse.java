package com.example.pss.domain.notice.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class NoticeResponse {
    private String title;
    private String imageUrl;
    private String introduction;

    private int viewCount;
    private float stars;
    private int likes;

    private boolean isMine;
    private String nickname;
    private String profileImage;
    private String email;

    private LocalDateTime createTime;
}
