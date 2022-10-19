package com.example.pss.domain.comment.domain.repository;

import com.example.pss.domain.comment.domain.Comment;
import com.example.pss.domain.reply.domain.Reply;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import static com.example.pss.domain.notice.domain.QNotice.notice;
import static com.example.pss.domain.comment.domain.QComment.comment;
import static com.example.pss.domain.reply.domain.QReply.reply;

@RequiredArgsConstructor
public class CommentCustomRepository implements CommentCustom{
    private final JPAQueryFactory query;

    @Override
    public List<Comment> findCommentsById(UUID noticeId) {
        return query.selectFrom(comment)
                .leftJoin(comment.notice, notice)
                .where(notice.id.eq(noticeId))
                .fetch();
    }

    @Override
    public List<Reply> findRepliesById(Long commentId) {
        return query.selectFrom(reply)
                .leftJoin(reply.comment, comment)
                .where(comment.id.eq(commentId))
                .fetch();
    }
}
