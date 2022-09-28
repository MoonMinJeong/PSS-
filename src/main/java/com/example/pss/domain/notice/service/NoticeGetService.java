package com.example.pss.domain.notice.service;

import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.notice.present.dto.response.NoticeListResponse;
import com.example.pss.domain.notice.present.dto.response.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeGetService {
    private final NoticeRepository noticeRepository;

    public NoticeListResponse getListByTime() {
        List<NoticeResponse> noticeResponseList = noticeRepository.findAllDesc()
                .stream()
                .map(notice -> NoticeResponse.builder()
                        .title(notice.getTitle())
                        .imageUrl(notice.getImageUrl())
                        .introduction(notice.getIntroduction())
                        .viewCount(notice.getViewCount())
                        .stars(notice.getStar())
                        .isMine(notice.isMine())
                        .nickname(notice.getUser().getNickname())
                        .profileImage(notice.getUser().getImageUrl())
                        .email(notice.getUser().getEmail())
                        .createTime(notice.getCreateTime())
                        .build()
                )
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
                        .isMine(notice.isMine())
                        .nickname(notice.getUser().getNickname())
                        .profileImage(notice.getUser().getImageUrl())
                        .email(notice.getUser().getEmail())
                        .createTime(notice.getCreateTime())
                        .build()
                )
                .collect(Collectors.toList());

        return new NoticeListResponse(noticeResponses);
    }

    public NoticeListResponse getListByTitle(String title) {
        List<NoticeResponse> noticeResponses = noticeRepository.findAllByTitle(title)
                .stream()
                .map(notice -> NoticeResponse.builder()
                        .title(notice.getTitle())
                        .imageUrl(notice.getImageUrl())
                        .introduction(notice.getIntroduction())
                        .viewCount(notice.getViewCount())
                        .stars(notice.getStar())
                        .isMine(notice.isMine())
                        .nickname(notice.getUser().getNickname())
                        .profileImage(notice.getUser().getImageUrl())
                        .email(notice.getUser().getEmail())
                        .createTime(notice.getCreateTime())
                        .build()
                )
                .collect(Collectors.toList());

        return new NoticeListResponse(noticeResponses);
    }
}
