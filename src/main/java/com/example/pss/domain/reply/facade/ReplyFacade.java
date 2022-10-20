package com.example.pss.domain.reply.facade;

import com.example.pss.domain.reply.domain.Reply;
import com.example.pss.domain.reply.domain.repository.ReplyRepository;
import com.example.pss.domain.reply.exception.ReplyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ReplyFacade {
    private final ReplyRepository replyRepository;

    public Reply findById(UUID replyId) {
        return replyRepository.findReplyById(replyId)
                .orElseThrow(() -> ReplyNotFoundException.EXCEPTION);
    }
}
