package com.example.pss.domain.notice.service;

import com.example.pss.domain.like.domain.repository.LikeRepository;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.domain.type.NoticeType;
import com.example.pss.domain.notice.present.dto.response.NoticeResponse;
import com.example.pss.domain.stack.facade.StackFacade;
import com.example.pss.domain.star.facade.StarFacade;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeGetService {

    private final UserFacade userFacade;
    private final NoticeRepository noticeRepository;
    private final LikeRepository likeRepository;
    private final StackFacade stackFacade;
    private final StarFacade starFacade;

    public NoticeResponse getNotice(String sort, float star, String title) {
        User user = userFacade.getCurrentUser();

        if (Objects.equals(sort, "time")) {
            if (Objects.equals(title, "")) {
                List<NoticeResponse.NoticeDto> noticeResponses = noticeRepository.findAllByStarGreaterThanEqualAndNoticeTypeOrderByCreateTimeDesc(star, NoticeType.POST)
                        .stream()
                        .map(this::noticeResponse)
                        .collect(Collectors.toList());

                return new NoticeResponse(noticeResponses);
            } else {
                List<NoticeResponse.NoticeDto> noticeResponses = noticeRepository.findAllByTitleContainsAndNoticeTypeAndStarGreaterThanEqualOrderByCreateTimeDesc(title, NoticeType.POST, star)
                        .stream()
                        .map(this::noticeResponse)
                        .collect(Collectors.toList());

                return new NoticeResponse(noticeResponses);
            }
        } else {
            if (Objects.equals(title, "")) {
                List<NoticeResponse.NoticeDto> noticeResponses = noticeRepository.findAllByStarGreaterThanEqualAndNoticeTypeOrderByStarDesc(star, NoticeType.POST)
                        .stream()
                        .map(this::noticeResponse)
                        .collect(Collectors.toList());

                return new NoticeResponse(noticeResponses);
            } else {
                List<NoticeResponse.NoticeDto> noticeResponses = noticeRepository.findAllByTitleContainsAndNoticeTypeAndStarGreaterThanEqualOrderByStarDesc(title, NoticeType.POST, star)
                        .stream()
                        .map(this::noticeResponse)
                        .collect(Collectors.toList());

                return new NoticeResponse(noticeResponses);
            }
        }
    }

    private NoticeResponse.NoticeDto noticeResponse(Notice notice) {
        return NoticeResponse.NoticeDto.builder()
                .noticeId(notice.getId())
                .name(notice.getUser().getNickname())
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
                .createTime(notice.getCreateTime().plusHours(9))
                .build();
    }
}
