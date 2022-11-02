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

    private Integer likes;

    private float stars;
    private List<String> stacks;
    private List<String> nicknames;
    private Integer viewCount;

    private boolean isMine;
    private boolean isLike;
    private boolean isStar;
    private boolean isReviewed;

    private float myStar;

    private String profileImage;
    private LocalDateTime createTime;
    private List<CommentResponse> list;
}
