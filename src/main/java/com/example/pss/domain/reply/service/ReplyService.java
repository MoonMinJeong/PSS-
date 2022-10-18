package com.example.pss.domain.reply.service;

import com.example.pss.domain.comment.domain.Comment;
import com.example.pss.domain.comment.facade.CommentFacade;
import com.example.pss.domain.reply.domain.Reply;
import com.example.pss.domain.reply.domain.repository.ReplyRepository;
import com.example.pss.domain.reply.present.dto.ReplyCreateRequest;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final CommentFacade commentFacade;
    private final UserFacade userFacade;

    public void create(ReplyCreateRequest request, Long commentId) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.findCommentById(commentId);

        replyRepository.save(
                Reply.builder()
                        .content(request.getContent())
                        .user(user)
                        .comment(comment)
                        .isMine(true)
                        .build()
        );
    }
}
