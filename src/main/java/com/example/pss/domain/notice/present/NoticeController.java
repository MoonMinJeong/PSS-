package com.example.pss.domain.notice.present;

import com.example.pss.domain.notice.present.dto.request.CreateRequest;
import com.example.pss.domain.notice.service.NoticeCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeCreateService noticeCreateService;

    @PostMapping
    public void create(@RequestBody @Valid CreateRequest request) {
        noticeCreateService.create(request);
    }
}
