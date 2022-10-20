package com.example.pss.domain.comment.service;

import com.example.pss.domain.comment.domain.Comment;
import com.example.pss.domain.comment.domain.repository.CommentRepository;
import com.example.pss.domain.comment.exception.NotMineException;
import com.example.pss.domain.comment.facade.CommentFacade;
import com.example.pss.domain.comment.present.dto.CommentRequest;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final NoticeFacade noticeFacade;
    private final CommentFacade commentFacade;

    public void create(UUID noticeId, CommentRequest request) {
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

    @Transactional
    public void update(UUID commentId, CommentRequest request) {
        Comment comment = commentFacade.findCommentById(commentId);
        User user = userFacade.getCurrentUser();

        if(!user.equals(comment.getUser())) {
            throw NotMineException.EXCEPTION;
        }

        comment.update(request.getContent());
    }

    @Transactional
    public void delete(UUID commentId) {
        Comment comment = commentFacade.findCommentById(commentId);

        commentRepository.delete(comment);
    }
}
