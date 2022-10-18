package com.example.pss.domain.comment.service;

import com.example.pss.domain.comment.domain.Comment;
import com.example.pss.domain.comment.domain.repository.CommentRepository;
import com.example.pss.domain.comment.present.dto.CommentCreateRequest;
import com.example.pss.domain.comment.present.dto.response.CommentListResponse;
import com.example.pss.domain.comment.present.dto.response.CommentResponse;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final NoticeFacade noticeFacade;


    public void create(CommentCreateRequest request, UUID noticeId) {
        User user = userFacade.getCurrentUser();
        Notice notice = noticeFacade.findById(noticeId);

        commentRepository.save(
                Comment.builder()
                        .content(request.getContent())
                        .isMine(true)
                        .user(user)
                        .notice(notice)
                        .build()
        );
    }

    public CommentListResponse read(UUID noticeId) {
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

        return new CommentListResponse(list);
    }
}
