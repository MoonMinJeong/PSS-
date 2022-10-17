package com.example.pss.domain.notice.present.dto.response;

import com.example.pss.domain.stack.domain.Stack;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class NoticeOneResponse {
    private String title;
    private String content;
    private float stars;
    private List<Stack> stacks;
    private int viewCount;
    private String email;
    private String profileImage;
    private LocalDateTime createTime;
}
