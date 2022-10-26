package com.example.pss.domain.reply.domain.repository;

import com.example.pss.domain.comment.domain.Comment;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.reply.domain.Reply;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReplyRepository extends CrudRepository<Reply, UUID> {
    Optional<Reply> findReplyById(UUID id);
    List<Reply> deleteAllByNotice(Notice notice);
    List<Reply> deleteAllByComment(Comment comment);
}
