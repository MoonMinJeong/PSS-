package com.example.pss.domain.notice.present.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Builder
public class CreateRequest {

    @NotBlank(message = "title 비어있으면 안됩니다")
    private String title;

    @NotBlank(message = "content 비어있으면 안됩니다")
    @Size(min = 20, max = 2000, message = "최소 20글자는 입력되어야 합니다.")
    private String content;

    @NotBlank(message = "imageUrl 비어있으면 안됩니다")
    private String imageUrl;

    private List<String> stacks;

    private List<String> nicknames;
}
