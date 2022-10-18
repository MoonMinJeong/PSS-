package com.example.pss.domain.notice.service;

import com.example.pss.domain.comment.domain.repository.CommentRepository;
import com.example.pss.domain.comment.present.dto.response.CommentListResponse;
import com.example.pss.domain.comment.present.dto.response.CommentResponse;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.notice.present.dto.response.NoticeOneResponse;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.stack.facade.StackFacade;
import com.example.pss.domain.star.domain.Star;
import com.example.pss.domain.star.domain.repository.StarRepository;
import com.example.pss.domain.star.exception.StarNotFoundException;
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
    private final StackFacade stackFacade;
    private final StarRepository starRepository;
    private final UserFacade userFacade;
    private final CommentRepository commentRepository;

    @Transactional
    public NoticeOneResponse getNotice(UUID noticeId) {
        User user = userFacade.getCurrentUser();
        Notice notice = noticeFacade.findById(noticeId);

        Star star = starRepository.findByNoticeAndUser(notice, user)
                .orElseThrow(() -> StarNotFoundException.EXCEPTION);

        notice.UpViewCount();
        

        List<CommentResponse> list = commentRepository.getByNotice(noticeId)
                .stream()
                .map(comment -> new CommentResponse(
                        comment.getUser().getNickname(),
                        comment.getContent(),
                        comment.getUser().getImageUrl(),
                        comment.isMine(),
                        commentRepository.getByComment(comment.getId())
                ))
                .collect(Collectors.toList());

        return NoticeOneResponse.builder()
                .noticeId(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .createTime(notice.getCreateTime())
                .profileImage(notice.getUser().getImageUrl())
                .email(notice.getUser().getEmail())
                .viewCount(notice.getViewCount())
                .stars(star.getStars())
                .stacks(stackFacade.findAllByNotice(notice))
                .list(list)
                .build();
    }
}
