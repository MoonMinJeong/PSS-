package com.example.pss.domain.comment.domain.repository;

import com.example.pss.domain.reply.domain.Reply;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.pss.domain.comment.domain.QComment.comment;
import static com.example.pss.domain.reply.domain.QReply.reply;

@RequiredArgsConstructor
public class CommentCustomRepository implements CommentCustom{
    private final JPAQueryFactory query;


    @Override
    public List<Reply> getByComment(Long commentId) {
        return query.selectFrom(reply)
                .where(reply.comment.id.eq(commentId))
                .fetch();
    }
}
