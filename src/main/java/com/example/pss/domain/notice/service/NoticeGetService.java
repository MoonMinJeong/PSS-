package com.example.pss.domain.notice.service;

import com.example.pss.domain.like.domain.repository.LikeRepository;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
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
    private final LikeRepository likeRepository;

    public NoticeListResponse getListByTime() {
        int likes = likeRepository.findAllByLikeCheckTrue().size();

        List<NoticeResponse> noticeResponseList = noticeRepository.findAllDesc()
                .stream()
                .map(notice -> NoticeResponse.builder()
                        .title(notice.getTitle())
                        .imageUrl(notice.getImageUrl())
                        .introduction(notice.getIntroduction())
                        .viewCount(notice.getViewCount())
                        .stars(notice.getStar())
                        .likes(likes)
                        .isMine(notice.isMine())
                        .nickname(notice.getUser().getNickname())
                        .profileImage(notice.getUser().getImageUrl())
                        .email(notice.getUser().getEmail())
                        .stacks(notice.getStacks())
                        .createTime(notice.getCreateTime())
                        .build()
                )
                .collect(Collectors.toList());

        return new NoticeListResponse(noticeResponseList);
    }

    public NoticeListResponse getListByStar() {
        int likes = likeRepository.findAllByLikeCheckTrue().size();

        List<NoticeResponse> noticeResponses = noticeRepository.findAllAndOrderByStarDesc()
                .stream()
                .map(notice -> NoticeResponse.builder()
                        .title(notice.getTitle())
                        .imageUrl(notice.getImageUrl())
                        .introduction(notice.getIntroduction())
                        .viewCount(notice.getViewCount())
                        .stars(notice.getStar())
                        .likes(likes)
                        .isMine(notice.isMine())
                        .nickname(notice.getUser().getNickname())
                        .profileImage(notice.getUser().getImageUrl())
                        .email(notice.getUser().getEmail())
                        .stacks(notice.getStacks())
                        .createTime(notice.getCreateTime())
                        .build()
                )
                .collect(Collectors.toList());

        return new NoticeListResponse(noticeResponses);
    }

    public NoticeListResponse getListByTitleOrderByStar(String title) {
        int likes = likeRepository.findAllByLikeCheckTrue().size();

        List<NoticeResponse> noticeResponses = noticeRepository.findAllByTitleOrderByStarDesc(title)
                .stream()
                .map(notice -> NoticeResponse.builder()
                        .title(notice.getTitle())
                        .imageUrl(notice.getImageUrl())
                        .introduction(notice.getIntroduction())
                        .viewCount(notice.getViewCount())
                        .stars(notice.getStar())
                        .likes(likes)
                        .isMine(notice.isMine())
                        .nickname(notice.getUser().getNickname())
                        .profileImage(notice.getUser().getImageUrl())
                        .email(notice.getUser().getEmail())
                        .stacks(notice.getStacks())
                        .createTime(notice.getCreateTime())
                        .build()
                )
                .collect(Collectors.toList());

        return new NoticeListResponse(noticeResponses);
    }

    public NoticeListResponse getListByTitleOrderByTime(String title) {

        int likes = likeRepository.findAllByLikeCheckTrue().size();

        List<NoticeResponse> noticeResponses = noticeRepository.findAllByTitleOrderByCreateTimeDesc(title)
                .stream()
                .map(notice -> NoticeResponse.builder()
                        .title(notice.getTitle())
                        .imageUrl(notice.getImageUrl())
                        .introduction(notice.getIntroduction())
                        .viewCount(notice.getViewCount())
                        .stars(notice.getStar())
                        .likes(likes)
                        .isMine(notice.isMine())
                        .nickname(notice.getUser().getNickname())
                        .profileImage(notice.getUser().getImageUrl())
                        .email(notice.getUser().getEmail())
                        .stacks(notice.getStacks())
                        .createTime(notice.getCreateTime())
                        .build()
                )
                .collect(Collectors.toList());

        return new NoticeListResponse(noticeResponses);
    }
}
