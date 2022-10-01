package com.example.pss.domain.notice.present.dto.response;

import com.example.pss.domain.stack.domain.Stack;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

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

    private List<Stack> stacks;

    private LocalDateTime createTime;
}
