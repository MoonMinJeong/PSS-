package com.example.pss.domain.comment.present;

import com.example.pss.domain.comment.present.dto.CommentRequest;
import com.example.pss.domain.comment.service.CommentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{noticeId}")
    public void create(@PathVariable("noticeId") UUID noticeId, @RequestBody @Valid CommentRequest request) {
        commentService.create(noticeId, request);
    }

    @PutMapping("/{commentId}")
    public void update(@PathVariable("commentId") UUID commentId, @RequestBody @Valid CommentRequest request) {
        commentService.update(commentId, request);
    }

    @DeleteMapping("/{commentId}")
    public void delete(@PathVariable("commentId") UUID commentId) {
        commentService.delete(commentId);
    }
}
