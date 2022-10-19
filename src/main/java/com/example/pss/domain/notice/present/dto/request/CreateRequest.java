package com.example.pss.domain.notice.present.dto.request;

import com.example.pss.global.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CreateRequest {

    @NotBlank(message = "title 비어있으면 안됩니다")
    private String title;

    @NotBlank(message = "content 비어있으면 안됩니다")
    private String content;

    @NotBlank(message = "imageUrl 비어있으면 안됩니다")
    private String imageUrl;

    private Type projectType;

    private String introduction;
}
