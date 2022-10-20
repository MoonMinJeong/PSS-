package com.example.pss.domain.comment.facade;

import com.example.pss.domain.comment.domain.Comment;
import com.example.pss.domain.comment.domain.repository.CommentRepository;
import com.example.pss.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CommentFacade {
    private final CommentRepository commentRepository;

    public Comment findCommentById(UUID commentId) {
        return commentRepository.findCommentById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }
}
