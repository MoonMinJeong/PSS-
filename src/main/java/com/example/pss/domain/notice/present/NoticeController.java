package com.example.pss.domain.notice.present;

import com.example.pss.domain.notice.present.dto.request.CreateRequest;
import com.example.pss.domain.notice.present.dto.request.CreateReviewRequest;
import com.example.pss.domain.notice.present.dto.request.UpdateRequest;
import com.example.pss.domain.notice.present.dto.response.NoticeIdResponse;
import com.example.pss.domain.notice.present.dto.response.NoticeOneResponse;
import com.example.pss.domain.notice.present.dto.response.NoticeResponse;
import com.example.pss.domain.notice.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RequestMapping("/notice")
@RestController
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeCreateService noticeCreateService;
    private final NoticeUpdateService noticeUpdateService;
    private final NoticeDeleteService noticeDeleteService;
    private final NoticeGetService noticeGetService;
    private final NoticeIntroService noticeIntroService;
    private final NoticeSaveService noticeSaveService;
    private final NoticeSaveListService noticeSaveListService;
    private final NoticeReviewCreateService noticeReviewCreateService;

    @PostMapping
    public NoticeIdResponse create(@RequestBody @Valid CreateRequest request) {
        return noticeCreateService.create(request);
    }

    @PostMapping("/save")
    public NoticeIdResponse save(@RequestBody @Valid CreateRequest request) {
        return noticeSaveService.save(request);
    }

    @PostMapping("/review/{noticeId}")
    public NoticeIdResponse review(@RequestBody @Valid CreateRequest request, @PathVariable("noticeId") UUID noticeId) {
        return noticeReviewCreateService.save(request, noticeId);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody @Valid UpdateRequest request, @PathVariable("id") UUID uuid) {
        noticeUpdateService.update(request, uuid);
    }

    @GetMapping("/{id}")
    public NoticeOneResponse getOne(@PathVariable("id") UUID noticeId) {
        return noticeIntroService.getNotice(noticeId);
    }

    @GetMapping
    public NoticeResponse getNotice(
            @RequestParam(value = "sort", defaultValue = "time", required = false) String sort,
            @RequestParam(value = "star", defaultValue = "0", required = false) float star,
            @RequestParam(value = "title", defaultValue = "", required = false) String title
    ) {
        return noticeGetService.getNotice(sort, star, title);
    }

    @GetMapping("/save")
    public NoticeResponse getSave() {
        return noticeSaveListService.saveList();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID uuid) {
        noticeDeleteService.delete(uuid);
    }
}
