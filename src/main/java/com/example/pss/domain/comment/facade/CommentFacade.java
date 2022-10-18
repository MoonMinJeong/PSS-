package com.example.pss.domain.comment.facade;

import com.example.pss.domain.comment.domain.Comment;
import com.example.pss.domain.comment.domain.repository.CommentRepository;
import com.example.pss.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentFacade {
    private final CommentRepository commentRepository;

    public Comment findCommentById(Long commentId) {
        return commentRepository.findCommentById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }
}
