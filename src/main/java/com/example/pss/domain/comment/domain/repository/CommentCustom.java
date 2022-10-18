package com.example.pss.domain.comment.domain.repository;

import com.example.pss.domain.reply.domain.Reply;

import java.util.List;

public interface CommentCustom {
    List<Reply> getByComment(Long commentId);
}
