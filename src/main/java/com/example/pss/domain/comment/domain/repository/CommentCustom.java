package com.example.pss.domain.comment.domain.repository;

import com.example.pss.domain.comment.domain.Comment;
import com.example.pss.domain.reply.domain.Reply;

import java.util.List;
import java.util.UUID;

public interface CommentCustom {
    List<Comment> getCommentById(UUID id);

    List<Reply> getReplyById(UUID id);
}
