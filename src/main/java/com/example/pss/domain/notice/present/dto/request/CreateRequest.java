package com.example.pss.domain.notice.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateRequest {

    @NotBlank(message = "title 비어있으면 안됩니다")
    private String title;

    @NotBlank(message = "content 비어있으면 안됩니다")
    private String content;

    private List<String> images;

    private List<String> stacks;

    private List<String> nicknames;

    private String introduction;
}
