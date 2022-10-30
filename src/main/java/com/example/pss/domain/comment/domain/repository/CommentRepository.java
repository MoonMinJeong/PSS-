package com.example.pss.domain.comment.domain.repository;

import com.example.pss.domain.comment.domain.Comment;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.reply.domain.Reply;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends CrudRepository<Comment, UUID>, CommentCustom {
    Optional<Comment> findCommentById(UUID id);

    List<Comment> findAllByNoticeId(UUID noticeId);

    List<Comment> deleteAllByNotice(Notice notice);
}
