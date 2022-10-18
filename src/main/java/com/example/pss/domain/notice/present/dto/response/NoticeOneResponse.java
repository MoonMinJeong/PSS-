package com.example.pss.domain.notice.present.dto.response;

import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.user.domain.User;
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
    private Integer viewCount;
    private String email;
    private String profileImage;
    private LocalDateTime createTime;
}
