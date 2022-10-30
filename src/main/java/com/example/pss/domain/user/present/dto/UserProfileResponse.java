package com.example.pss.domain.user.present.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UserProfileResponse {
    private List<NoticeDto> noticeList;
    private List<NoticeDto> reviewList;
    private String profileImage;
    private String nickname;
    private String email;
    private int noticeCount;

    @Getter
    @AllArgsConstructor
    @Builder
    public static class NoticeDto {
        private UUID noticeId;
        private String title;
        private String imageUrl;
        private String introduction;
        private List<String> stacks;

        private Integer viewCount;
        private float stars;
        private Integer likes;

        private boolean isMine;

        private String nickname;
        private String profileImage;

        private LocalDateTime createTime;
    }
}