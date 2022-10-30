package com.example.pss.domain.reply.service;

import com.example.pss.domain.comment.domain.Comment;
import com.example.pss.domain.comment.facade.CommentFacade;
import com.example.pss.domain.reply.domain.Reply;
import com.example.pss.domain.reply.domain.repository.ReplyRepository;
import com.example.pss.domain.reply.facade.ReplyFacade;
import com.example.pss.domain.reply.present.dto.ReplyRequest;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final CommentFacade commentFacade;
    private final ReplyFacade replyFacade;
    private final UserFacade userFacade;

    public void create(UUID commentId, ReplyRequest request) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.findCommentById(commentId);

        replyRepository.save(
                Reply.builder()
                        .content(request.getContent())
                        .user(user)
                        .notice(comment.getNotice())
                        .comment(comment)
                        .isMine(true)
                        .build()
        );
    }

    @Transactional
    public void update(UUID replyId, ReplyRequest request) {
        Reply reply = replyFacade.findById(replyId);

        reply.update(request.getContent());
    }

    @Transactional
    public void delete(UUID id) {
        Reply reply = replyFacade.findById(id);

        replyRepository.delete(reply);
    }
}
