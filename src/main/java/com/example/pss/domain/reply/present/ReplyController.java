package com.example.pss.domain.reply.present;

import com.example.pss.domain.reply.present.dto.ReplyRequest;
import com.example.pss.domain.reply.service.ReplyService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/{commentId}")
    public void create(@PathVariable("commentId") @NonNull UUID commentId, @RequestBody @Valid ReplyRequest request) {
        replyService.create(commentId, request);
    }

    @PutMapping("/{replyId}")
    public void update(@PathVariable("replyId") @NonNull UUID replyId, @RequestBody @Valid ReplyRequest request) {
        replyService.update(replyId, request);
    }

    @DeleteMapping("/{replyId}")
    public void delete(@PathVariable("replyId") @NonNull UUID replyId) {
        
    }
}
