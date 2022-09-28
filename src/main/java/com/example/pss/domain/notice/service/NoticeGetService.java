package com.example.pss.domain.notice.service;

import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.notice.present.dto.response.NoticeListResponse;
import com.example.pss.domain.notice.present.dto.response.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeGetService {
    private final NoticeFacade noticeFacade;
    private final NoticeRepository noticeRepository;

    public NoticeListResponse getListByTime() {
        List<NoticeResponse> noticeResponseList = noticeRepository.findAllDesc()
                .stream()
                .map(notice -> new NoticeResponse(notice.getTitle(), notice.getImageUrl(), notice.getIntroduction(), notice.getViewCount(), notice.getStar(), notice.getCreateTime()))
                .collect(Collectors.toList());

        return new NoticeListResponse(noticeResponseList);
    }

    public NoticeListResponse getListByStar() {
        List<NoticeResponse> noticeResponses = noticeRepository.findAll()
                .stream()
                .map(notice -> NoticeResponse.builder()
                        .title(notice.getTitle())
                        .imageUrl(notice.getImageUrl())
                        .introduction(notice.getIntroduction())
                        .viewCount(notice.getViewCount())
                        .stars(notice.getStar())
                        .createTime(notice.getCreateTime())
                        .build()
                )
                .collect(Collectors.toList());

        return new NoticeListResponse(noticeResponses);
    }
}
