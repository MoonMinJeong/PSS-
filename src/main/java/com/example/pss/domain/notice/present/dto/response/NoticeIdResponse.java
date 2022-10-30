package com.example.pss.domain.notice.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class NoticeIdResponse {
    private UUID noticeId;
}
