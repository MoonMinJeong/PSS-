package com.example.pss.domain.notice.present;

import com.example.pss.domain.notice.present.dto.request.CreateRequest;
import com.example.pss.domain.notice.present.dto.request.UpdateRequest;
import com.example.pss.domain.notice.present.dto.response.NoticeOneResponse;
import com.example.pss.domain.notice.present.dto.response.NoticeResponse;
import com.example.pss.domain.notice.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/notice")
@RestController
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeCreateService noticeCreateService;
    private final NoticeUpdateService noticeUpdateService;
    private final NoticeDeleteService noticeDeleteService;
    private final NoticeGetService noticeGetService;
    private final NoticeIntroService noticeIntroService;

    @PostMapping
    public void create(@RequestBody @Valid CreateRequest request) {
        noticeCreateService.create(request);
    }

    @PatchMapping("/{id}")
    public void update(@RequestBody @Valid UpdateRequest request, @PathVariable("id") UUID uuid) {
        noticeUpdateService.update(request, uuid);
    }
    @GetMapping("/{id}")
    public NoticeOneResponse getOne(@PathVariable("id") UUID noticeId) {
        return noticeIntroService.getNotice(noticeId);
    }

    @GetMapping("/time")
    public NoticeResponse getListByTime() {
        return noticeGetService.getListByTime();
    }

    @GetMapping("/star")
    public NoticeResponse getListByStar() {
        return noticeGetService.getListByStar();
    }

    @GetMapping("/star/{title}")
    public NoticeResponse getListByTitleOrderByStar(@PathVariable("title") String title) {
        return noticeGetService.getListByTitleOrderByStar(title);
    }

    @GetMapping("/time/{title}")
    public NoticeResponse getListByTitleOrderByTime(@PathVariable("title") String title) {
        return noticeGetService.getListByTitleOrderByTime(title);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID uuid) {
        noticeDeleteService.delete(uuid);
    }
}
