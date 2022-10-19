package com.example.pss.domain.notice.service;

import com.example.pss.domain.like.domain.repository.LikeRepository;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.present.dto.response.NoticeResponse;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.stack.facade.StackFacade;
import com.example.pss.domain.star.facade.StarFacade;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeGetService {
    private final NoticeRepository noticeRepository;
    private final LikeRepository likeRepository;
    private final StackRepository stackRepository;
    private final StackFacade stackFacade;
    private final StarFacade starFacade;
    private final UserFacade userFacade;

    public NoticeResponse getAll() {
        User user = userFacade.getCurrentUser();

        List<NoticeResponse.NoticeDto> list = noticeRepository.findAll()
                .stream()
                .map(notice ->
                        NoticeResponse.NoticeDto.builder()
                                .noticeId(notice.getId())
                                .title(notice.getTitle())
                                .imageUrl(notice.getImageUrl())
                                .introduction(notice.getIntroduction())
                                .viewCount(notice.getViewCount())
                                .stars(starFacade.findAllByNotice(notice))
                                .likes(likeRepository.findAllByNotice(notice).size())
                                .isMine(notice.isMine())
                                .nickname(notice.getUser().getNickname())
                                .profileImage(notice.getUser().getImageUrl())
                                .stacks(stackFacade.findAllByNotice(notice))
                                .createTime(notice.getCreateTime())
                                .build()
                )
                .collect(Collectors.toList());

        return new NoticeResponse(list);
    }

    public NoticeResponse getListByTime() {
        User user = userFacade.getCurrentUser();


        List<NoticeResponse.NoticeDto> noticeResponseList = noticeRepository.findAllDesc()
                .stream()
                .map(notice ->
                        NoticeResponse.NoticeDto.builder()
                                .noticeId(notice.getId())
                                .title(notice.getTitle())
                                .imageUrl(notice.getImageUrl())
                                .introduction(notice.getIntroduction())
                                .viewCount(notice.getViewCount())
                                .stars(starFacade.findAllByNotice(notice))
                                .likes(likeRepository.findAllByNotice(notice).size())
                                .isMine(notice.isMine())
                                .nickname(notice.getUser().getNickname())
                                .profileImage(notice.getUser().getImageUrl())
                                .stacks(stackFacade.findAllByNotice(notice))
                                .createTime(notice.getCreateTime())
                                .build()
                )
                .collect(Collectors.toList());

        return new NoticeResponse(noticeResponseList);
    }

    public NoticeResponse getListByStar() {
        User user = userFacade.getCurrentUser();

        List<NoticeResponse.NoticeDto> noticeResponses = noticeRepository.findAllAndOrderByStarDesc()
                .stream()
                .map(notice -> NoticeResponse.NoticeDto.builder()
                        .noticeId(notice.getId())
                        .title(notice.getTitle())
                        .imageUrl(notice.getImageUrl())
                        .introduction(notice.getIntroduction())
                        .viewCount(notice.getViewCount())
                        .stars(starFacade.findAllByNotice(notice))
                        .likes(likeRepository.findAllByNotice(notice).size())
                        .isMine(notice.isMine())
                        .nickname(notice.getUser().getNickname())
                        .profileImage(notice.getUser().getImageUrl())
                        .stacks(stackFacade.findAllByNotice(notice))
                        .createTime(notice.getCreateTime())
                        .build()
                )
                .collect(Collectors.toList());

        return new NoticeResponse(noticeResponses);
    }

    public NoticeResponse getListByTitleOrderByStar(String title) {
        User user = userFacade.getCurrentUser();

        List<NoticeResponse.NoticeDto> noticeResponses = noticeRepository.findAllByTitleOrderByStarDesc(title)
                .stream()
                .map(notice -> NoticeResponse.NoticeDto.builder()
                        .noticeId(notice.getId())
                        .title(notice.getTitle())
                        .imageUrl(notice.getImageUrl())
                        .introduction(notice.getIntroduction())
                        .viewCount(notice.getViewCount())
                        .stars(starFacade.findAllByNotice(notice))
                        .likes(likeRepository.findAllByNotice(notice).size())
                        .isMine(notice.isMine())
                        .nickname(notice.getUser().getNickname())
                        .profileImage(notice.getUser().getImageUrl())
                        .stacks(stackFacade.findAllByNotice(notice))
                        .createTime(notice.getCreateTime())
                        .build()
                )
                .collect(Collectors.toList());

        return new NoticeResponse(noticeResponses);
    }

    public NoticeResponse getListByTitleOrderByTime(String title) {
        User user = userFacade.getCurrentUser();

        List<NoticeResponse.NoticeDto> noticeResponses = noticeRepository.findAllByTitleOrderByCreateTimeDesc(title)
                .stream()
                .map(notice -> NoticeResponse.NoticeDto.builder()
                        .noticeId(notice.getId())
                        .title(notice.getTitle())
                        .imageUrl(notice.getImageUrl())
                        .introduction(notice.getIntroduction())
                        .viewCount(notice.getViewCount())
                        .stars(starFacade.findAllByNotice(notice))
                        .likes(likeRepository.findAllByNotice(notice).size())
                        .isMine(notice.isMine())
                        .nickname(notice.getUser().getNickname())
                        .profileImage(notice.getUser().getImageUrl())
                        .stacks(stackFacade.findAllByNotice(notice))
                        .createTime(notice.getCreateTime())
                        .build()
                )
                .collect(Collectors.toList());

        return new NoticeResponse(noticeResponses);
    }
}
