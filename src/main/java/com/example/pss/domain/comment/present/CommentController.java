package com.example.pss.domain.comment.present;

import com.example.pss.domain.comment.present.dto.CommentCreateRequest;
import com.example.pss.domain.comment.present.dto.response.CommentListResponse;
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
    public void create(@PathVariable("noticeId") @NonNull UUID noticeId, @RequestBody @Valid CommentCreateRequest request) {
        commentService.create(noticeId, request);
    }

    @GetMapping("/{id}")
    public CommentListResponse readAll(@PathVariable("id") UUID id) {
        return commentService.readAll(id);
    }
}
