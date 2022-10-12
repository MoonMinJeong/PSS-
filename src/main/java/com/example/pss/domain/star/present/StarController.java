package com.example.pss.domain.star.present;

import com.example.pss.domain.star.present.dto.StarRequest;
import com.example.pss.domain.star.service.StarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/star")
public class StarController {
    private final StarService service;

    @PostMapping("/{noticeId}")
    public void create(@PathVariable("noticeId") UUID noticeId, @RequestBody @Valid StarRequest request) {
        service.create(noticeId, request);
    }

    @PutMapping("/{noticeId}")
    public void update(@PathVariable("noticeId") UUID noticeId, @RequestBody @Valid StarRequest request) {
        service.update(noticeId, request);
    }
}
