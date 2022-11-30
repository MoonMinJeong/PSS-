package com.example.pss.domain.notice.present.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class ReviewResponse {
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
    
    private float myStar;

    private String profileImage;
    private LocalDateTime createTime;
}
