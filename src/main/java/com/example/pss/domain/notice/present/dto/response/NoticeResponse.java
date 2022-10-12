package com.example.pss.domain.notice.present.dto.response;

import com.example.pss.domain.stack.domain.Stack;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class NoticeResponse {
    private List<NoticeDto> noticeList;

    @Getter
    @Builder
    public static class NoticeDto {
        private String title;
        private String imageUrl;
        private String introduction;
        private List<Stack> stacks;

        private int viewCount;
        private float stars;
        private int likes;

        private boolean isMine;
        private boolean isLike;
        private String nickname;
        private String profileImage;

        private LocalDateTime createTime;

        @QueryProjection
        public NoticeDto(
                String title, String imageUrl, String introduction, int viewCount,
                float stars, int likes, boolean isMine, boolean isLike, String nickname,
                String profileImage, String email, List<Stack> stacks, LocalDateTime createTime) {
            this.title = title;
            this.imageUrl = imageUrl;
            this.introduction = introduction;
            this.stacks = stacks;
            this.nickname = nickname;
            this.profileImage = profileImage;
            this.likes = likes;
            this.stars = stars;
            this.viewCount = viewCount;
        }
    }
}
