package com.example.pss.domain.notice.present.dto.response;

import com.example.pss.domain.stack.domain.Stack;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private float stars;
    private List<String> stacks;
    private int viewCount;
    private String email;
    private String profileImage;
    private LocalDateTime createTime;
}
