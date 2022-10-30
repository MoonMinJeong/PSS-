package com.example.pss.domain.reply.present;

import com.example.pss.domain.reply.present.dto.ReplyRequest;
import com.example.pss.domain.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/{id}")
    public void create(@PathVariable("id") UUID id, @RequestBody @Valid ReplyRequest request) {
        replyService.create(id, request);
    }

    @PutMapping("/{replyId}")
    public void update(@PathVariable("replyId") UUID replyId, @RequestBody @Valid ReplyRequest request) {
        replyService.update(replyId, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        replyService.delete(id);
    }
}
