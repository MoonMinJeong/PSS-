package com.example.pss.domain.notice.present.dto.response;

import com.example.pss.domain.stack.domain.Stack;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class NoticeResponse {
    private List<NoticeDto> noticeList;

    @Getter
    @AllArgsConstructor
    @Builder
    public static class NoticeDto {
        private UUID noticeId;
        private String title;
        private String imageUrl;
        private String introduction;
        private List<String> stacks;
        private List<String> nicknames;

        private Integer viewCount;
        private float stars;
        private Integer likes;

        private boolean isMine;

        private String nickname;
        private String profileImage;

        private LocalDateTime createTime;

        @QueryProjection
        public NoticeDto(
                UUID noticeId, String title, String imageUrl, String introduction, Integer viewCount,
                float stars, Integer likes, String nickname, boolean isMine,
                String profileImage, List<String> stacks, List<String> nicknames, LocalDateTime createTime) {
            this.noticeId = noticeId;
            this.title = title;
            this.imageUrl = imageUrl;
            this.introduction = introduction;
            this.stacks = stacks;
            this.nicknames = nicknames;
            this.nickname = nickname;
            this.profileImage = profileImage;
            this.likes = likes;
            this.stars = stars;
            this.viewCount = viewCount;
            this.isMine = isMine;
            this.createTime = createTime;
        }
    }
}
