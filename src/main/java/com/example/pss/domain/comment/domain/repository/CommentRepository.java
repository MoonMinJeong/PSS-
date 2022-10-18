package com.example.pss.domain.comment.domain.repository;

import com.example.pss.domain.comment.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends CrudRepository<Comment, Long>, CommentCustom {
    Optional<Comment> findCommentById(Long id);
    List<Comment> findAllByNoticeId(UUID noticeId);
}
