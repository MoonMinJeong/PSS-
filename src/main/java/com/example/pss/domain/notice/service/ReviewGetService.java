package com.example.pss.domain.notice.service;

import com.example.pss.domain.comment.domain.repository.CommentRepository;
import com.example.pss.domain.comment.present.dto.response.CommentResponse;
import com.example.pss.domain.like.domain.repository.LikeRepository;
import com.example.pss.domain.member.facade.MemberFacade;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.notice.present.dto.response.NoticeOneResponse;
import com.example.pss.domain.notice.present.dto.response.ReviewResponse;
import com.example.pss.domain.review.domain.repository.ReviewRepository;
import com.example.pss.domain.stack.facade.StackFacade;
import com.example.pss.domain.star.domain.repository.StarRepository;
import com.example.pss.domain.star.facade.StarFacade;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ReviewGetService {
    private final NoticeFacade noticeFacade;
    private final MemberFacade memberFacade;
    private final StackFacade stackFacade;
    private final StarFacade starFacade;
    private final StarRepository starRepository;
    private final UserFacade userFacade;
    private final CommentRepository commentRepository;
    private final ReviewRepository reviewRepository;
    private final LikeRepository likeRepository;

    @Transactional
    public ReviewResponse getNotice(UUID noticeId) {
        User user = userFacade.getCurrentUser();
        Notice notice = noticeFacade.findById(noticeId);

        notice.UpViewCount();

        return ReviewResponse.builder()
                .noticeId(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .likes(likeRepository.findAllByNotice(notice).size())
                .stars(starFacade.findAllByNotice(notice))
                .stacks(stackFacade.findAllByNotice(notice))
                .nicknames(memberFacade.findAllByNotice(notice))
                .viewCount(notice.getViewCount())
                .isMine(notice.isMine())
                .isLike(likeRepository.findByUserAndNotice(user, notice).isPresent())
                .isStar(starRepository.findByNoticeAndUser(notice, user).isPresent())
                .myStar(starFacade.findByNoticeAndUser(notice, user))
                .createTime(notice.getCreateTime().plusHours(9))
                .profileImage(notice.getUser().getImageUrl())
                .build();
    }
}
