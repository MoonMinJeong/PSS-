package com.example.pss.domain.notice.present.dto.response;

import com.example.pss.domain.comment.present.dto.response.CommentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class NoticeOneResponse {
    private UUID noticeId;
    private String title;
    private String content;

    private String name;

    private Integer likes;

    private float stars;
    private List<String> stacks;
    private List<String> nicknames;
    private Integer viewCount;

    private Boolean isMine;
    private Boolean isLike;
    private Boolean isStar;
    private Boolean isReviewed;

    private UUID reviewId;

    private float myStar;

    private String profileImage;
    private LocalDateTime createTime;
    private List<CommentResponse> list;
}
