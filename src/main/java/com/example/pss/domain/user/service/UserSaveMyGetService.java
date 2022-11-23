package com.example.pss.domain.user.service;

import com.example.pss.domain.like.domain.repository.LikeRepository;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.domain.type.NoticeType;
import com.example.pss.domain.stack.facade.StackFacade;
import com.example.pss.domain.star.facade.StarFacade;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import com.example.pss.domain.user.present.dto.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserSaveMyGetService {
    private final UserFacade userFacade;
    private final NoticeRepository noticeRepository;
    private final StarFacade starFacade;
    private final LikeRepository likeRepository;
    private final StackFacade stackFacade;

    public UserProfileResponse getMySavePost() {
        User user = userFacade.getCurrentUser();

        List<UserProfileResponse.NoticeDto> noticeResponses = noticeRepository.findAllByUserAndNoticeType(user, NoticeType.SAVE)
                .stream()
                .map(notice ->
                        UserProfileResponse.NoticeDto.builder()
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
                                .createTime(notice.getCreateTime().plusHours(9))
                                .build()
                )
                .collect(Collectors.toList());

        return UserProfileResponse.builder()
                .noticeCount(noticeResponses.size())
                .email(user.getEmail())
                .profileImage(user.getImageUrl())
                .nickname(user.getNickname())
                .noticeList(noticeResponses)
                .build();
    }
}
