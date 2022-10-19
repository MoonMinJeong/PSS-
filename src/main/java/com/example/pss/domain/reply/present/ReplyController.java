package com.example.pss.domain.reply.present;

import com.example.pss.domain.reply.present.dto.ReplyCreateRequest;
import com.example.pss.domain.reply.service.ReplyService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/{commentId}")
    public void create(@PathVariable("commentId") @NonNull Long commentId, @RequestBody @Valid ReplyCreateRequest request) {
        replyService.create(request, commentId);
    }
}
