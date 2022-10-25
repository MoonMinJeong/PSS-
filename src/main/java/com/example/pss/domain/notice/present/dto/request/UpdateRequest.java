package com.example.pss.domain.notice.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class UpdateRequest {
    private String title;
    private String content;
    private List<String> images;
    private List<String> stacks;
    private List<String> members;
    private String introduction;
}
