package com.example.pss.domain.reply.domain.repository;

import com.example.pss.domain.reply.domain.Reply;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository extends CrudRepository<Reply, Long> {
    Optional<Reply> findReplyById(Long id);
}
