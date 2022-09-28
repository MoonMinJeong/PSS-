package com.example.pss.domain.notice.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class NoticeListResponse {
    private List<NoticeResponse> noticeResponses;
}
