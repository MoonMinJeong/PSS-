package com.example.pss.domain.notice.service;

import com.example.pss.domain.comment.domain.repository.CommentRepository;
import com.example.pss.domain.comment.present.dto.response.CommentResponse;
import com.example.pss.domain.image.facade.ImageFacade;
import com.example.pss.domain.like.domain.repository.LikeRepository;
import com.example.pss.domain.member.facade.MemberFacade;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.notice.present.dto.response.NoticeOneResponse;
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
public class NoticeIntroService {
    private final NoticeFacade noticeFacade;
    private final MemberFacade memberFacade;
    private final StackFacade stackFacade;
    private final StarFacade starFacade;
    private final ImageFacade imageFacade;
    private final StarRepository starRepository;
    private final UserFacade userFacade;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;

    @Transactional
    public NoticeOneResponse getNotice(UUID noticeId) {
        User user = userFacade.getCurrentUser();
        Notice notice = noticeFacade.findById(noticeId);

        notice.UpViewCount();

        List<CommentResponse> list = commentRepository.getCommentById(noticeId)
                .stream()
                .map(comment ->
                        new CommentResponse(
                                comment.getId(),
                                comment.getUser().getNickname(),
                                comment.getContent(),
                                comment.getUser().getImageUrl(),
                                comment.isMine(),
                                commentRepository.getReplyById(comment.getId())
                        ))
                .collect(Collectors.toList());

        return NoticeOneResponse.builder()
                .noticeId(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .imageUrl(imageFacade.findAllByNotice(notice))
                .stars(starFacade.findAllByNotice(notice))
                .stacks(stackFacade.findAllByNotice(notice))
                .nicknames(memberFacade.findAllByNotice(notice))
                .viewCount(notice.getViewCount())
                .isMine(notice.isMine())
                .isLike(likeRepository.findByUserAndNotice(user, notice).isPresent())
                .isStar(starRepository.findByNoticeAndUser(notice, user).isPresent())
                .myStar(starFacade.findByNoticeAndUser(notice, user))
                .createTime(notice.getCreateTime())
                .profileImage(notice.getUser().getImageUrl())
                .list(list)
                .build();
    }
}
