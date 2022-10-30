package com.example.pss.domain.user.service;

import com.example.pss.domain.like.domain.repository.LikeRepository;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.domain.type.NoticeType;
import com.example.pss.domain.stack.facade.StackFacade;
import com.example.pss.domain.star.facade.StarFacade;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import com.example.pss.domain.user.present.dto.UserProfileResponse;
import com.example.pss.domain.user.present.dto.UserReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserMyPostGetService {
    private final UserFacade userFacade;
    private final NoticeRepository noticeRepository;
    private final StarFacade starFacade;
    private final LikeRepository likeRepository;
    private final StackFacade stackFacade;

    public UserReviewResponse getMyPost() {
        User user = userFacade.getCurrentUser();

        List<UserReviewResponse.NoticeDto> noticeResponses = noticeRepository.findAllByUserAndNoticeType(user, NoticeType.POST)
                .stream()
                .map(notice ->
                        UserReviewResponse.NoticeDto.builder()
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

        List<UserReviewResponse.NoticeDto> noticeResponses2 = noticeRepository.findAllByUserAndNoticeType(user, NoticeType.REVIEW)
                .stream()
                .map(notice ->
                        UserReviewResponse.NoticeDto.builder()
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

        return UserReviewResponse.builder()
                .noticeCount(noticeResponses.size())
                .email(user.getEmail())
                .profileImage(user.getImageUrl())
                .nickname(user.getNickname())
                .reviewList(noticeResponses2)
                .noticeList(noticeResponses)
                .build();
    }
}
